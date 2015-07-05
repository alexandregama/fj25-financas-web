package br.com.caelum.financas.mb;

import java.util.List;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {

	private Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;
	
	private List<ValorPorMesEAno> lista;

	private Movimentacoes movimentacoes;
	
	@Inject
	public MesesComMovimentacaoBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	MesesComMovimentacaoBean() {
	}
	
	public void pesquisa() {
		System.out.println("Listando as contas pelos valores movimentados no mes");
		this.lista = movimentacoes.listaMesesComMovimentacoesPorContaETipo(conta, tipoMovimentacao);
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}
	
	public List<ValorPorMesEAno> getLista() {
		return lista;
	}

}
