package br.com.agendamento_simples.common;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("FASE ID: " + event.getPhaseId());
		System.out.println("FASE: " + event.getPhaseId().getName());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}