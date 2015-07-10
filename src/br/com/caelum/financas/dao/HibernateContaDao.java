package br.com.caelum.financas.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;

@Stateless
class HibernateContaDao implements Contas {

	@Inject
	private EntityManager manager;

	@PostConstruct
	public void posConstruct() {
		System.out.println("Criando o ContaDao");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Destruindo o ContaDao");
	}

	@Override
	public void adiciona(Conta conta) throws AgenciaEmBrancoException {
		manager.joinTransaction();
		this.manager.persist(conta);
		
		if (conta.getTitular() == null || conta.getTitular().isEmpty()) {
			throw new TitularEmBrancoException("Não é permitido Titular em branco"); 
		} 
			
		if (conta.getBanco() == null || conta.getBanco().isEmpty()) {
			throw new BancoEmBrancoException("Não é permitido o Banco em branco");
		}
	}
	
	@Override
	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	@Override
	public List<Conta> lista() {
		String jpql = "select c from Conta c";
		TypedQuery<Conta> query = manager.createQuery(jpql, Conta.class);
		
		return query.getResultList();
	}

	@Override
	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		manager.joinTransaction();
		this.manager.remove(contaParaRemover);
	}

	@Override
	public void atualiza(Conta conta) {
		manager.joinTransaction();
		this.manager.merge(conta);
	}

}




