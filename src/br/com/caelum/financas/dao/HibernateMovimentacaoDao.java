package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.caelum.financas.mb.Movimentacoes;
import br.com.caelum.financas.mb.ValorPorMesEAno;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Stateless
public class HibernateMovimentacaoDao implements Movimentacoes {

	@Inject
	private EntityManager manager;

	@Override
	public void adiciona(Movimentacao movimentacao) {
		manager.joinTransaction();
		manager.persist(movimentacao);
		
		if (movimentacao.isValorNegativo()) {
			throw new ValorInvalidoException("Não é permitido valores negativos");
		}
	}

	@Override
	public Movimentacao busca(Integer id) {
		return manager.find(Movimentacao.class, id);
	}

	@Override
	public List<Movimentacao> lista() {
		return manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}

	@Override
	public void remove(Movimentacao movimentacao) {
		manager.joinTransaction();
		Movimentacao movimentacaoParaRemover = this.manager.find(Movimentacao.class, movimentacao.getId());
		manager.remove(movimentacaoParaRemover);
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
	
	@Override
	public List<ValorPorMesEAno> listaMesesComMovimentacoesPorContaETipoETotalMinimo(Conta conta, TipoMovimentacao tipoMovimentacao, BigDecimal totalMinimo) {
		String jpql = "select " +
				"   new br.com.caelum.financas.mb.ValorPorMesEAno(year(m.data), month(m.data), sum(m.valor)) " + 
				"from " +
				"	  Movimentacao m " +
				"where " +
				"	  m.conta = :conta and m.tipoMovimentacao = :tipo " +
				"group by " +
				"   year(m.data), month(m.data)" +
				"having " +
				"	sum(m.valor) > :minimo";
		
		TypedQuery<ValorPorMesEAno> query = manager.createQuery(jpql, ValorPorMesEAno.class);
		query.setParameter("conta", conta);
		query.setParameter("tipo", tipoMovimentacao);
		query.setParameter("minimo", totalMinimo);
		
		List<ValorPorMesEAno> movimentacoes = query.getResultList();
		
		return movimentacoes;
	}

	@Override
	public List<Movimentacao> listaMovimentacoesPorCriteria() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> criteria = builder.createQuery(Movimentacao.class);
		criteria.from(Movimentacao.class);
		
		TypedQuery<Movimentacao> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Movimentacao> listaMovimentacoesPorCriteriaReduzida() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> criteria = builder.createQuery(Movimentacao.class);
		criteria.from(Movimentacao.class);
		
		return manager.createQuery(criteria).getResultList();
	}

	@Override
	public BigDecimal listaPorTitularDaContaComCriteria(String nomeTitular) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<BigDecimal> criteria = builder.createQuery(BigDecimal.class);
		Root<Movimentacao> root = criteria.from(Movimentacao.class);
		
		Path<BigDecimal> valor = root.<BigDecimal>get("valor");
		Expression<BigDecimal> soma = builder.sum(valor);
		
		criteria.select(soma);
		
		Path<String> titular = root.<Conta>get("conta").<String>get("titular");
		Predicate equal = builder.equal(titular, nomeTitular);
		
		criteria.where(equal);
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteria);
		
		return query.getSingleResult();
	}

	@Override
	public BigDecimal listaPorTitularDaContaComCriteriaReduzida(String nomeTitular) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> criteria = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = criteria.from(Movimentacao.class);
		
		criteria.select(builder.sum(root.<BigDecimal>get("valor")));
		criteria.where(builder.equal(root.<Conta>get("conta").<String>get("titular"), nomeTitular));
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteria);
		
		return query.getSingleResult();
	}

	@Override
	public List<Movimentacao> listaComCategorias() {
		String jpql = "select distinct m from Movimentacao m left join fetch m.categorias";
		TypedQuery<Movimentacao> query = manager.createQuery(jpql, Movimentacao.class);
		
		return query.getResultList();
	}
	
}
