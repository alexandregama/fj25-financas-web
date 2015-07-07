package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.AgenciaEmBrancoException;
import br.com.caelum.financas.dao.Contas;
import br.com.caelum.financas.modelo.Conta;

@Named
@ViewScoped
public class ContasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private Contas contas;
    
	private Conta conta = new Conta();
	
	private List<Conta> lista;

	public ContasBean(Contas contas) {
		this.contas = contas;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() throws AgenciaEmBrancoException {
		System.out.println("Gravando a conta");
		if (conta.getId() != null) {
			contas.atualiza(conta);
		} else {
			contas.adiciona(conta);
		}
		this.lista = contas.lista();
		
		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		System.out.println("Listando as contas");
		if (this.lista == null) {
			this.lista = contas.lista();
		}
		return lista;
	}

	public void remove() {
		System.out.println("Removendo a conta");
		this.contas.remove(conta);
		this.lista = contas.lista();
		limpaFormularioDoJSF();
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
