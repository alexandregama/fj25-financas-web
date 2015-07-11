package br.com.caelum.financas.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.Contas;
import br.com.caelum.financas.modelo.Conta;

@Named
@ViewScoped
public class LockPessimistaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contas contas;
	
	private Conta conta;

	@Inject
	public LockPessimistaBean(Contas contas) {
		this.contas = contas;
	}
	
	@Deprecated //CDI eyes only
	LockPessimistaBean() {
	}
	
	public void pesquisa() {
		this.conta = contas.buscaComLockPessimista(13);
	}
	
	public void salva() {
		contas.atualiza(conta);
	}
	
}
