package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.financas.modelo.Movimentacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CriteriaBean {
	
	private List<Movimentacao> lista;
	
	private BigDecimal soma;
	
	private String titular;

	private Movimentacoes movimentacoes;
	
	@Inject
	public CriteriaBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	CriteriaBean() {
	}

	public void listarTodasAsMovimentacoes() {
		this.lista = movimentacoes.listaMovimentacoesPorCriteria();
	}
	
	public void listarTodasAsMovimentacoesCriteriaReduzida() {
		this.lista = movimentacoes.listaMovimentacoesPorCriteriaReduzida();
	}

	public void somaMovimentacoesDoTitular() {

	}
	
	public List<Movimentacao> getMovimentacoes() {
		return lista;
	}
	
	public BigDecimal getSoma() {
		return soma;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
}
