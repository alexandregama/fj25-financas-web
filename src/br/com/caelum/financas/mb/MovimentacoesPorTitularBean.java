package br.com.caelum.financas.mb;

import java.util.List;
import br.com.caelum.financas.modelo.Movimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> movimentacoes;
	private String titular;
	
	

	public void lista() {
		System.out.println("Buscando as movimentacoes pelo titular da conta " + this.titular);

	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
