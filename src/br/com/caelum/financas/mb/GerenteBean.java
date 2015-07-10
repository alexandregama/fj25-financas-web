package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Gerentes;
import br.com.caelum.financas.modelo.Gerente;

@Named
@ViewScoped
public class GerenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Gerentes gerentes;

	private List<Gerente> lista;
	
	private Gerente gerente = new Gerente();
	
	@Inject
	public GerenteBean(Gerentes gerentes) {
		this.gerentes = gerentes;
	}
	
	@Deprecated //CDI eyes only
	GerenteBean() {
	}

	public void salva() {
		if (gerente.getId() == null) {
			gerentes.cadastra(gerente);
		} else {
			gerentes.atualiza(gerente);
		}
		
		limpaFormulario();
	}

	public List<Gerente> getLista() {
		if (lista == null) {
			lista = gerentes.lista();
		}
		return lista;
	}
	
	private void limpaFormulario() {
		gerente = new Gerente();
		lista = null;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
}
