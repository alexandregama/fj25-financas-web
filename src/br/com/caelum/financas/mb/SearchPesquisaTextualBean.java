package br.com.caelum.financas.mb;

import java.util.List;
import br.com.caelum.financas.modelo.Movimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SearchPesquisaTextualBean {

	private String descricao;
	private List<Movimentacao> movimentacoes;
	
	
	public void pesquisar() {

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
