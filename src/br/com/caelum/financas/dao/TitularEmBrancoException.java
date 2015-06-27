package br.com.caelum.financas.dao;

public class TitularEmBrancoException extends RuntimeException { 
//Neste caso temos uma System Exception pois é uma RuntimeException
//Mata o Bean
//Faz rollback na Transacao
//Lança EJBException e não TitularEmBrancoException	

	private static final long serialVersionUID = 905176707350315739L;

	public TitularEmBrancoException(String message) {
		super(message);
	}
	
}
