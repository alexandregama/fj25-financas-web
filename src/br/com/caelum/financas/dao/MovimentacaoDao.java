package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.mb.Movimentacoes;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@Stateless
public class MovimentacaoDao implements Movimentacoes {

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

}
