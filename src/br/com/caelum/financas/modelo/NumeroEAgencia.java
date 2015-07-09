package br.com.caelum.financas.modelo;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE})
@Constraint(validatedBy = NumeroEAgenciaValidator.class)
public @interface NumeroEAgencia {

	String message() default "{br.com.caelum.financas.validator.NumeroEAgencia.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
