package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Categorias;
import br.com.caelum.financas.modelo.Categoria;

@Named
@ViewScoped
public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categorias categorias;
	
	private List<Categoria> lista;
	
	private Categoria categoria = new Categoria();

	private JsfMessage messages;
	
	@Inject
	public CategoriaBean(Categorias categorias, JsfMessage messages) {
		this.categorias = categorias;
		this.messages = messages;
	}
	
	@Deprecated //CDI eyes only
	CategoriaBean() {
	}
	
	public void salva() {
		if (categoria.getId() == null) {
			categorias.salva(categoria);
			messages.addInfo("Categoria salva com sucesso!");
		} else {
			categorias.atualiza(categoria);
			messages.addInfo("Categoria atualizada com sucesso!");
		}
		
		limpaFormulario();
	}
	
	public void remove(Categoria categoria) {
		categorias.remove(categoria);
		
		messages.addInfo("Categoria removida com sucesso!");
		
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
