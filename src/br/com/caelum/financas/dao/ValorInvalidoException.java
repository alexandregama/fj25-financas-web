package br.com.caelum.financas.dao;

import javax.ejb.ApplicationException;

@ApplicationException
public class ValorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 7520208244600565514L;

	public ValorInvalidoException(String message) {
		super(message);
	}
	
}
