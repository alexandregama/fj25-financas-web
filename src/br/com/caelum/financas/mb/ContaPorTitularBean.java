package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Contas;
import br.com.caelum.financas.modelo.Conta;

@Named
@RequestScoped
public class ContaPorTitularBean {

	private Contas contas;
	
	private Conta conta = new Conta();
	
	private List<Conta> lista;

	@Inject
	public ContaPorTitularBean(Contas contas) {
		this.contas = contas;
	}
	
	@Deprecated //CDI eyes ony
	ContaPorTitularBean() {
	}
	
	public void pesquisa() {
		lista = contas.buscaPorTitularCriteria(conta.getTitular());
	}
	
	public List<Conta> getLista() {
		if (lista == null) {
			lista = contas.lista();
		}
		return lista;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
