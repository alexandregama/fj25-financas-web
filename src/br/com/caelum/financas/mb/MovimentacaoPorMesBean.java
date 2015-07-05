package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class MovimentacaoPorMesBean {

	private Movimentacoes movimentacoes;
	
	private List<ValorPorMesEAno> lista;

	@Inject
	public MovimentacaoPorMesBean(Movimentacoes movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	@Deprecated //CDI eyes only
	MovimentacaoPorMesBean() {
	}
	
	public List<ValorPorMesEAno> getLista() {
		if (lista == null) {
			lista = movimentacoes.listaMesesComMovimentacoes();
		}
		return lista;
	}
	
}
