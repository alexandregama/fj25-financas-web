package br.com.caelum.financas.mb;


import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {

	private Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;
	
	public void lista() {
		System.out.println("Listando as contas pelos valores movimentados no mes");

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

}
