package br.com.caelum.financas.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import br.com.caelum.financas.modelo.Conta;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidacaoBean {

	private Conta conta = new Conta();
	

	public void validar() {
		System.out.println("Validando a conta");
		
	}
	
	public Conta getConta() {
		return conta;
	}

	/**
	 * Esse metodo disponibiliza uma mensagem para a tela JSF.
	 */
	private void geraMensagemJsf(ConstraintViolation<Conta> erro) {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(erro.getPropertyPath().toString() + "  " + erro.getMessage()));
	}
	

	
}
