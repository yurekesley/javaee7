package br.com.yurekesley.feature.event.observers;

import javax.enterprise.event.Observes;

import br.com.yurekesley.feature.event.Desligamento;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

public class DesligamentoObserver implements EventObserver<Funcionario> {

    public void listen(@Observes @Desligamento(TipoDesligamento.APOSENTADORIA) Funcionario funcionario) {
	System.out.println("DesligamentoObserver APOSENTADORIA");
    }

}
