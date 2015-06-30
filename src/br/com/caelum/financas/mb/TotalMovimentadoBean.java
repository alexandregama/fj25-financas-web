package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Named
@RequestScoped
public class TotalMovimentadoBean {
	
	private BigDecimal total = BigDecimal.ZERO;
	private Conta conta = new Conta();
	private TipoMovimentacao tipoMovimentacao;
	private Movimentacoes movimentacoes;
	
	@Inject
	public TotalMovimentadoBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	@Deprecated //CDI eyes only
	TotalMovimentadoBean() {
	}

	public void calcula() {
		System.out.println("Total movimentado pela conta");
		Optional<BigDecimal> total = movimentacoes.valorTotalDa(conta);
		if (total.isPresent()) {
			this.total = total.get(); 
		}
	}

	public BigDecimal getTotal() {
		return total;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}
