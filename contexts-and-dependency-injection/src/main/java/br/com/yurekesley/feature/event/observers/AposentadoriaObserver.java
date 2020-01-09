package br.com.yurekesley.feature.event.observers;

import javax.enterprise.event.Observes;

import br.com.yurekesley.feature.event.Aposentadoria;
import br.com.yurekesley.model.Funcionario;

public class AposentadoriaObserver implements EventObserver<Funcionario> {

    public void listen(@Observes @Aposentadoria Funcionario funcionario) {
	System.out.println("AposentadoriaObserver");
    }

}
