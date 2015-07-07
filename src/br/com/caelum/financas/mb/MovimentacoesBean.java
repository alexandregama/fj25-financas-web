package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Categorias;
import br.com.caelum.financas.dao.Contas;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@Named
@ViewScoped
public class MovimentacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Movimentacoes movimentacoes;
	
	@Inject
	private Contas contas;
	
	private List<Categoria> listaCategorias;
	
	private List<Movimentacao> listaDeMovimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private Integer categoriaId;

	private Categorias categorias;
	
	@Inject
	public MovimentacoesBean(Movimentacoes movimentacoes, Contas contas, Categorias categorias) {
		this.movimentacoes = movimentacoes;
		this.contas = contas;
		this.categorias = categorias;
	}
	
	@Deprecated //CDI eyes only
	MovimentacoesBean() {
	}
	
	public void grava() {
		System.out.println("Fazendo a gravacao da movimentacao");
		
		Conta contaSelecionada = contas.busca(contaId);
		movimentacao.setConta(contaSelecionada);
		movimentacoes.adiciona(movimentacao);
		listaDeMovimentacoes = movimentacoes.lista();
		
		limpaFormularioDoJSF();
	}
	
	public void remove() {
		System.out.println("Removendo a movimentacao");
		
		movimentacoes.remove(movimentacao);
		listaDeMovimentacoes = movimentacoes.lista();
		
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		if (listaDeMovimentacoes == null) {
			listaDeMovimentacoes = movimentacoes.lista();
		}
		return listaDeMovimentacoes;
	}
	
	public Movimentacao getMovimentacao() {
		if (movimentacao.getData() == null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}

	public List<Categoria> getListaCategorias() {
		if (listaCategorias == null) {
			listaCategorias = categorias.lista();
		}
		return listaCategorias;
	}
	
	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
}
