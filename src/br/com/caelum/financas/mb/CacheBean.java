package br.com.caelum.financas.mb;

import br.com.caelum.financas.modelo.Conta;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CacheBean {
	
	private Integer id;
	private Conta conta;
	
	public void pesquisar() {
			System.out.println("Testando cache de primeiro nivel");
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