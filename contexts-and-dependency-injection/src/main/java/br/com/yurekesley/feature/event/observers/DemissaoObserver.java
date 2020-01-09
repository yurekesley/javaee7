package br.com.yurekesley.feature.event.observers;

import javax.enterprise.event.Observes;

import br.com.yurekesley.feature.event.Demissao;
import br.com.yurekesley.model.Funcionario;

public class DemissaoObserver implements EventObserver<Funcionario> {

    public void listen(@Observes @Demissao Funcionario target) {
	System.out.println("DemissaoObserver");
    }

}
