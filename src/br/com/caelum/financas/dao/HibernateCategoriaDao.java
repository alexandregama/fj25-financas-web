package br.com.caelum.financas.dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Categoria;

@Stateless
public class HibernateCategoriaDao implements Categorias {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Categoria> lista() {
		String jpql = "select c from Categoria c";
		TypedQuery<Categoria> query = manager.createQuery(jpql, Categoria.class);
		
		return query.getResultList();
	}

	@Override
	public Optional<Categoria> buscaPor(Long id) {
		Categoria categoria = manager.find(Categoria.class, id);
		
		return Optional.ofNullable(categoria);
	}

	@Override
	public void salva(Categoria categoria) {
		manager.joinTransaction();
		manager.persist(categoria);
	}

}
