package br.com.yurekesley.feature.event.jsf;

import javax.enterprise.event.Event;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class EventPhaseListenerCDI2_0 implements PhaseListener {

    private static final long serialVersionUID = 1L;

    @Inject
    // @After @RestoreView qualificando o evento do jsf
    private Event<PhaseEvent> afterRestoreView;

    public void afterPhase(PhaseEvent event) {
	afterRestoreView.fire(event);
    }

    public void beforePhase(PhaseEvent event) {
	// TODO Auto-generated method stub

    }

    public PhaseId getPhaseId() {
	return PhaseId.RESTORE_VIEW;
    }

}
