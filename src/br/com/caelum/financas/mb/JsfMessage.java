package br.com.caelum.financas.mb;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Stateless
public class JsfMessage {

	public void addInfo(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(message);
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		context.addMessage(null, facesMessage);
	}

}
