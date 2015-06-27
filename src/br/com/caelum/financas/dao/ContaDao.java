package br.com.caelum.financas.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.modelo.Conta;

@Stateless
public class ContaDao {

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	public void posConstruct() {
		System.out.println("Criando o ContaDao");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Destruindo o ContaDao");
	}

	public void adiciona(Conta conta) throws AgenciaEmBrancoException {
		this.manager.persist(conta);
		
		if (conta.getTitular() == null || conta.getTitular().isEmpty()) {
			throw new TitularEmBrancoException("Não é permitido Titular em branco"); 
		} 
		
		if (conta.getAgencia() == null || conta.getAgencia().isEmpty()) {
			throw new AgenciaEmBrancoException("Não é permitida a Agencia em branco");
		}
			
		if (conta.getBanco() == null || conta.getBanco().isEmpty()) {
			throw new BancoEmBrancoException("Não é permitido o Banco em branco");
		}
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}

	public void remove(Conta conta) {
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		this.manager.remove(contaParaRemover);
	}

	public void atualiza(Conta conta) {
		this.manager.merge(conta);
	}

}




