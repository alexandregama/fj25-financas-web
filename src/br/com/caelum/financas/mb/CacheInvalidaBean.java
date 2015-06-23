package br.com.caelum.financas.mb;

import br.com.caelum.financas.modelo.Conta;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CacheInvalidaBean {
	
	private Integer id;
	private Conta conta;
	

	public void invalidar() {
		System.out.println("Invalidando o cache programaticamente");
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Conta getConta() {
		return conta;
	}
}
