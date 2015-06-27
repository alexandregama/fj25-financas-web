package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.Pool;

@Stateless
@Pool(value = "slsb-strict-max-pool")
public class Agendador {

	private static int totalCriado;

	public void executa() {
		System.out.printf("%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}
	
	@PostConstruct
	public void posConstrucao() {
		System.out.println("Criando o Agendador");
		totalCriado++;
	}
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo o Agendador");
	}

}
