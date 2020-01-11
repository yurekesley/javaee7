package br.com.yurekesley.feature.event.observers;

import javax.enterprise.event.Observes;
import javax.inject.Named;

/*
 * O evento somente será disparado se existir um bean EventObserverReception disponível 
 */

@Named
public class EventObserverReception {
    public void observeEvent(@Observes String message) {
	System.out.println(message);
    }
}
