package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Singleton
@Startup
public class AgendadorTimerServiceScheduleExpression {

	@Resource
	private TimerService timerService;
	
	public AgendadorTimerServiceScheduleExpression() {
		System.out.println("Construindo o AgendadorTimerServiceScheduleExpression");
	}

	@PostConstruct
	public void postConstruct() {
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour(22);
		expression.minute(25);
		timerService.createCalendarTimer(expression);
	}
	
	@Timeout
	public void executa(Timer timer) {
		System.out.println("Executando o AgendadorTimerServiceScheduleExpression usando ScheduleExpression");
		System.out.println("Timer: " + timer);
	}
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo o AgendadorTimerService");
	}

}
