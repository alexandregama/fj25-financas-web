package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;
import br.com.caelum.financas.modelo.Movimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CriteriaBean {
	
	private List<Movimentacao> movimentacoes;
	private BigDecimal soma;
	
	private String titular;
	

	public void listarTodasAsMovimentacoes() {

	}

	public void somaMovimentacoesDoTitular() {

	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
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
