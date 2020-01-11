package br.com.yurekesley.feature.event.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class EventPhaseListenerCDI1_1 implements PhaseListener {

    private static final long serialVersionUID = 1L;

    public void afterPhase(PhaseEvent event) {
	// BeanManager beanManager = new CdiUtils().getBeanManager();
	// beanManager.fireEvent(event, new AnnotationLiteral<After>() {},new AnnotationLiteral<RestoreView>(){});
    }

    public void beforePhase(PhaseEvent event) {
	// TODO Auto-generated method stub

    }

    public PhaseId getPhaseId() {
	return PhaseId.RESTORE_VIEW;
    }

}
