package br.com.caelum.financas.modelo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumeroEAgenciaValidator implements ConstraintValidator<NumeroEAgencia, Conta> {

	@Override
	public void initialize(NumeroEAgencia annotation) {
	}

	@Override
	public boolean isValid(Conta conta, ConstraintValidatorContext context) {
		if (conta == null) {
			return true;
		}
		boolean agenciaEhVazia = conta.getAgencia() == null || conta.getAgencia().trim().isEmpty();
		boolean numeroEhVazio = conta.getNumero() == null || conta.getNumero().trim().isEmpty();
		
		boolean valid = !(agenciaEhVazia ^ numeroEhVazio);
		return valid;
	}

}
