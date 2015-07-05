package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.mb.Movimentacoes;
import br.com.caelum.financas.mb.ValorPorMesEAno;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Stateless
public class HibernateMovimentacaoDao implements Movimentacoes {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Movimentacao movimentacao) {
		this.manager.persist(movimentacao);
		
		if (movimentacao.isValorNegativo()) {
			throw new ValorInvalidoException("Não é permitido valores negativos");
		}
	}

	@Override
	public Movimentacao busca(Integer id) {
		return this.manager.find(Movimentacao.class, id);
	}

	@Override
	public List<Movimentacao> lista() {
		return this.manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}

	@Override
	public void remove(Movimentacao movimentacao) {
		Movimentacao movimentacaoParaRemover = this.manager.find(Movimentacao.class, movimentacao.getId());
		this.manager.remove(movimentacaoParaRemover);
	}
	
	@Override
	public List<Movimentacao> buscaPorConta(Conta conta) {
		String sql = "select m from Movimentacao m where m.conta = :conta";
		TypedQuery<Movimentacao> query = manager.createQuery(sql, Movimentacao.class);
		query.setParameter("conta", conta);
		
		return query.getResultList();
	}

	@Override
	public List<Movimentacao> listaPorValorETipo(BigDecimal valor, TipoMovimentacao tipo) {
		String sql = "select m from Movimentacao m where m.valor <= :valor and m.tipoMovimentacao = :tipo";
		TypedQuery<Movimentacao> query = manager.createQuery(sql, Movimentacao.class);
		query.setParameter("valor", valor);
		query.setParameter("tipo", tipo);
		
		return query.getResultList();
	}

	@Override
	public Optional<BigDecimal> valorTotalDa(Conta conta) {
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :conta";
		TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class);
		query.setParameter("conta", conta);
		
		return Optional.ofNullable(query.getSingleResult());
	}

	@Override
	public List<Movimentacao> listaPorTitular(String titular) {
		String jpql = "select m from Movimentacao m where m.conta.titular like :titular";
		TypedQuery<Movimentacao> query = manager.createQuery(jpql, Movimentacao.class);
		query.setParameter("titular", "%" + titular + "%");
		
		return query.getResultList() == null ? Arrays.asList() : query.getResultList();
	}

	public List<ValorPorMesEAno> listaMesesComMovimentacoes() {
		String jpql = "select " +
					  "   new br.com.caelum.financas.mb.ValorPorMesEAno(year(m.data), month(m.data), sum(m.valor)) " +
					  "from " +
					  "	  Movimentacao m " +
					  "group by " +
					  "	  year(m.data), month(m.data)";
		
		TypedQuery<ValorPorMesEAno> query = manager.createQuery(jpql, ValorPorMesEAno.class);
		List<ValorPorMesEAno> movimentacoes = query.getResultList();
		
		return movimentacoes;
	}

	@Override
	public List<ValorPorMesEAno> listaMesesComMovimentacoesPorContaETipo(Conta conta, TipoMovimentacao tipoMovimentacao) {
		String jpql = "select " +
				 	  "   new br.com.caelum.financas.mb.ValorPorMesEAno(year(m.data), month(m.data), sum(m.valor)) " + 
					  "from " +
					  "	  Movimentacao m " +
					  "where " +
					  "	  m.conta = :conta and m.tipoMovimentacao = :tipo " +
					  "group by " +
					  "   year(m.data), month(m.data)";
		
		TypedQuery<ValorPorMesEAno> query = manager.createQuery(jpql, ValorPorMesEAno.class);
		query.setParameter("conta", conta);
		query.setParameter("tipo", tipoMovimentacao);
		
		List<ValorPorMesEAno> movimentacoes = query.getResultList();
		
		return movimentacoes;
	}
}
