package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import br.com.caelum.financas.mb.PeriodoAgendamento;

@Singleton
public class AgendadorExercicio {

	@Resource
	private TimerService timerService;
	
	public void agenda(PeriodoAgendamento periodo) {
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour("*");
		expression.minute(periodo.getExpressaoEmMinutos());
		expression.second(periodo.getExpressaoEmSegundos());
		
		TimerConfig config = new TimerConfig();
		config.setInfo(expression);
		config.setPersistent(false);
		
		timerService.createCalendarTimer(expression, config);
	}
	
	@Timeout
	public void executa(Timer timer) {
		System.out.println(timer.getInfo());
		System.out.println("Executando o Agendador do Exercicio");
	}
	
	@Schedule(hour = "*", minute = "*/30")
	public void enviaEmailComUltimasMovimentacoes() {
		System.out.println("Enviando email com as ultimas modificacoes");
	}
	
	@PostConstruct
	public void posConstrucao() {
		System.out.println("Criando o Agendador");
	}
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo o Agendador");
	}

}
