package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@Startup
public class AgendadorTimerService {

	@Resource
	private TimerService timerService;
	
	public AgendadorTimerService() {
		System.out.println("Construindo o AgendadorTimerService");
	}

	@PostConstruct
	public void postConstruct() {
		timerService.createTimer(5000L, "Criando o Timer para o AgendadorTimerService");
	}
	
	@Timeout
	public void executa(Timer timer) {
		System.out.println("Executando o AgendadorTimerService usando @Timeout");
		System.out.println("Timer: " + timer);
	}
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo o AgendadorTimerService");
	}

}
