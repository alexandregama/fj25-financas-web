package br.com.caelum.financas.dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BancoEmBrancoException extends RuntimeException {
//É uma System Exception pois herda de RuntimeException mas se comporta como ApplicationException
//Não mata o bean como ApplicationException
//Faz o Rollback
//Com @ApplicationException lança BancoEmBrancoException e não EJBException
	
	private static final long serialVersionUID = 8914850577524901190L;

	public BancoEmBrancoException(String message) {
		super(message);
	}
	
}
