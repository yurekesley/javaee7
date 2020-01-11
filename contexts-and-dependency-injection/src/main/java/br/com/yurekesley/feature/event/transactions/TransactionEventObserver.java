package br.com.yurekesley.feature.event.transactions;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Named;

/*
 * O atributo [durint] define se o observer irá executar em algum erro transacional,
 * neste caso com TransactionPhase.AFTER_SUCCESS somente será executado o evento depois de uma transação 
 * bem sucedida. 
 */

@Named
public class TransactionEventObserver {
    public void observeImportantMessage(@Observes(during = TransactionPhase.AFTER_SUCCESS) String message) {
	System.out.println(message);
    }
}
