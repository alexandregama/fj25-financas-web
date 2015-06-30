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

	private List<Movimentacao> listaDeMovimentacoes;
	
	private Conta conta = new Conta();
	
	@Inject
	private Movimentacoes movimentacoes;
	
	public void lista() {
		this.listaDeMovimentacoes = movimentacoes.buscaPorConta(conta);
	}

	public List<Movimentacao> getMovimentacoes() {
		return listaDeMovimentacoes;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
