package br.com.caelum.financas.dao;

public class AgenciaEmBrancoException extends Exception {
//Neste caso temos uma ApplicationException, pois é uma checked
//Não faz Rollback
//Nao mata o Bean
//Lança AgenciaEmBrancoException	
	
	private static final long serialVersionUID = 1L;

	public AgenciaEmBrancoException(String message) {
		super(message);
	}
}
