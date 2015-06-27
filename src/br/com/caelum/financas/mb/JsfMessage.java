package br.com.caelum.financas.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfMessage {

	public void addInfo(String string) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Agendamento registrado com sucesso");
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, facesMessage);
	}

}
