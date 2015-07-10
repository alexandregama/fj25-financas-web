package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@Named
@RequestScoped
public class MovimentacoesDaContaBean {

	private List<Movimentacao> lista;
	
	private Conta conta = new Conta();
	
	private Movimentacoes movimentacoes;
	
	@Inject
	public MovimentacoesDaContaBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	MovimentacoesDaContaBean() {
	}
	
	public void pesquisar() {
		this.lista = movimentacoes.buscaPorConta(conta);
	}

	public List<Movimentacao> getLista() {
		return lista;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
