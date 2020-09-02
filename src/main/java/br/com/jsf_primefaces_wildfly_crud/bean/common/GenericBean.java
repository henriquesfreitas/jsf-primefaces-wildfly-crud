package br.com.jsf_primefaces_wildfly_crud.bean.common;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class GenericBean {
	
	protected void addMessageInfo(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_INFO, message);
	}
	
	protected void addMessageWarn(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_WARN, message);
	}
	
	protected void addMessageError(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_ERROR, message);
	}
	
	protected void addMessageFatal(String message) {
		addMessageWithSeverity(FacesMessage.SEVERITY_FATAL, message);
	}
	
	protected void addMessageException(String message) {
		addMessage("messages", new FacesMessage(message));
	}
	
	private void addMessageWithSeverity(Severity severity, String message) {
		addMessage("message", new FacesMessage(severity, message, ""));
	}
	
	private void addMessage(String messageId, FacesMessage facesMessage) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(messageId, facesMessage);		
	}
}
