package br.com.caelum.financas.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.service.AgendadorSingleton;

@Named
@RequestScoped
public class CicloDeVidaSingletonBean {
	
	@Inject
	private AgendadorSingleton agendador;
	
	public void executeAgendador() {
		agendador.executa();
	}
	
}
