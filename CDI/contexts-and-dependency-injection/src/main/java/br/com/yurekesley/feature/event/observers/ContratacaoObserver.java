package br.com.yurekesley.feature.event.observers;

import javax.enterprise.event.Observes;

import br.com.yurekesley.feature.event.Contratacao;
import br.com.yurekesley.model.Funcionario;

public class ContratacaoObserver implements EventObserver<Funcionario> {

    public void listen(@Observes @Contratacao Funcionario funcionario) {
	System.out.println("ContratacaoObserver");
    }

}
