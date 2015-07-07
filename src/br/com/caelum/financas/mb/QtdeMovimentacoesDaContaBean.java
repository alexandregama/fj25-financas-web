package br.com.caelum.financas.mb;

import br.com.caelum.financas.dao.Contas;
import br.com.caelum.financas.modelo.Conta;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class QtdeMovimentacoesDaContaBean {
	
	private Conta conta = new Conta();
	
	private int quantidade;

	private Contas contas;
	
	@Inject
	public QtdeMovimentacoesDaContaBean(Contas contas) {
		this.contas = contas;
	}
	
	@Deprecated //CDI eyes only
	QtdeMovimentacoesDaContaBean() {
	}
	
	public void lista() {
		System.out.println("Exibindo as quantidades de movimentacoes da conta");
		Conta contaEncontrada = contas.busca(conta.getId());
		quantidade = contaEncontrada.quantidadeDeMovimentacoes();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
