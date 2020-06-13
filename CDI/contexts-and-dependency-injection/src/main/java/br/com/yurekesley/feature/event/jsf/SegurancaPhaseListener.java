package br.com.yurekesley.feature.event.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class SegurancaPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    public void afterPhase(PhaseEvent event) {
	// verifica se o usuário está logado
	// se não estiver, envia para tela de login

    }

    public void beforePhase(PhaseEvent event) {
	// TODO Auto-generated method stub

    }

    public PhaseId getPhaseId() {
	return PhaseId.RESTORE_VIEW;
    }

}
