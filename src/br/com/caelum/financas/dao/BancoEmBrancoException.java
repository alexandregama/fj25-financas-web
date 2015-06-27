package br.com.caelum.financas.dao;

public class BancoEmBrancoException extends RuntimeException {
//É uma System Exception pois herda de RuntimeException
//Mata o bean
//Faz o Rollback
//Lança EJBException	
	
	private static final long serialVersionUID = 8914850577524901190L;

	public BancoEmBrancoException(String message) {
		super(message);
	}
	
}
