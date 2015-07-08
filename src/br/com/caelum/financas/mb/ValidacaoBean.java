package br.com.caelum.financas.mb;

import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.modelo.Conta;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidacaoBean {

	private Conta conta = new Conta();
	
	private Validator validator;
	
	@Inject
	public ValidacaoBean(Validator validator) {
		this.validator = validator;
	}
	
	@Deprecated //CDI eyes only
	ValidacaoBean() {
	}

	public void validar() {
		System.out.println("Validando a conta");
		Set<ConstraintViolation<Conta>> errors = validator.validate(conta);
		for(ConstraintViolation<Conta> erro: errors) {
			geraMensagemJsf(erro);
		}
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
