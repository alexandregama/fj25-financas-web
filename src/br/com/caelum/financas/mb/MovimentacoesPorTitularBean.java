package br.com.caelum.financas.mb;

import java.util.List;

import br.com.caelum.financas.modelo.Movimentacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> listaDeMovimentacoes;
	private String titular;
	private Movimentacoes movimentacoes;

	@Inject
	public MovimentacoesPorTitularBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	MovimentacoesPorTitularBean() {
	}
	
	public void lista() {
		System.out.println("Buscando as movimentacoes pelo titular da conta " + this.titular);
		this.listaDeMovimentacoes = movimentacoes.listaPorTitular(titular);
	}

	public List<Movimentacao> getMovimentacoes() {
		return listaDeMovimentacoes;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
