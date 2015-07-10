package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Gerente;

@Stateless
public class HibernateGerenteDao implements Gerentes {

	private EntityManager manager;
	
	@Inject
	public HibernateGerenteDao(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated //CDI eyes only
	HibernateGerenteDao() {
	}
	
	@Override
	public List<Gerente> lista() {
		String jpql = "select g from Gerente g";
		TypedQuery<Gerente> query = manager.createQuery(jpql, Gerente.class);
		
		return query.getResultList();
	}

	@Override
	public void cadastra(Gerente gerente) {
		manager.joinTransaction();
		manager.persist(gerente);
	}

	@Override
	public void atualiza(Gerente gerente) {
		manager.joinTransaction();
		Gerente gerenteParaAtualizar = manager.find(Gerente.class, gerente.getId());
		manager.merge(gerenteParaAtualizar);
	}

}
