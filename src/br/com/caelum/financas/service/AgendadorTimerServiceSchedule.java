package br.com.caelum.financas.service;

import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Singleton
@Startup
public class AgendadorTimerServiceSchedule {
	
	public AgendadorTimerServiceSchedule() {
		System.out.println("Construindo o AgendadorTimerServiceSchedule");
	}
	
	@Schedule(hour = "*", minute = "*/30", second = "0")
	public void executa(Timer timer) {
		System.out.println("Executando o AgendadorTimerServiceSchedule usando Schedule");
		System.out.println("Timer: " + timer);
	}
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo o AgendadorTimerServiceSchedule");
	}

}
