package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Categorias;
import br.com.caelum.financas.modelo.Categoria;

@Named
@RequestScoped
public class CategoriaBean {

	private Categorias categorias;
	
	private List<Categoria> lista;
	
	private Categoria categoria = new Categoria();
	
	@Inject
	public CategoriaBean(Categorias categorias) {
		this.categorias = categorias;
	}
	
	@Deprecated //CDI eyes only
	CategoriaBean() {
	}
	
	public void salva() {
		categorias.salva(categoria);
		
		limpaFormulario();
	}
	
	public void remove(Categoria categoria) {
		categorias.remove(categoria);
		
		limpaFormulario();
	}

	public List<Categoria> getLista() {
		if (lista == null) {
			lista = categorias.lista();
		}
		return lista;
	}
	
	private void limpaFormulario() {
		categoria = new Categoria();
		lista = null;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
