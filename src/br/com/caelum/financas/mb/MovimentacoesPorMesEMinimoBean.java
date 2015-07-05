package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@RequestScoped
@Named
public class MovimentacoesPorMesEMinimoBean {

	private Movimentacoes movimentacoes;
	
	private Conta conta = new Conta();
	
	private TipoMovimentacao tipoMovimentacao;
	
	private BigDecimal totalMinimo;
	
	private List<ValorPorMesEAno> lista;

	@Inject
	public MovimentacoesPorMesEMinimoBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	MovimentacoesPorMesEMinimoBean() {
	}
	
	public void pesquisa() {
		System.out.println("Pesquisando por Conta, Tipo e Total mínimo");
		this.lista = movimentacoes.listaMesesComMovimentacoesPorContaETipoETotalMinimo(conta, tipoMovimentacao, totalMinimo);
	}
	
	public List<ValorPorMesEAno> getLista() {
		return lista;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public BigDecimal getTotalMinimo() {
		return totalMinimo;
	}

	public void setTotalMinimo(BigDecimal totalMinimo) {
		this.totalMinimo = totalMinimo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
