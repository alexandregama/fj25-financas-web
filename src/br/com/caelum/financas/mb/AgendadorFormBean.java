package br.com.caelum.financas.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.service.AgendadorExercicio;

@Named
@RequestScoped
public class AgendadorFormBean {

	private PeriodoAgendamento periodo = new PeriodoAgendamento();

	@Inject
	private AgendadorExercicio agendador;
	
	@Inject
	private JsfMessage facesMessage;
	
	public void agendar() {
		agendador.agenda(periodo);
		
		facesMessage.addInfo("Agendamento registrado com sucesso");
	}

	public PeriodoAgendamento getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoAgendamento periodo) {
		this.periodo = periodo;
	}

}
