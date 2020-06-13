package br.com.yurekesley.jms.aplicacao_a;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.yurekesley.feature.event.Desligamento;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

public class GerenciadorFuncionarioBean {
   
    @Inject
    @Desligamento(TipoDesligamento.DEMISSAO)
    private Event<Funcionario> eventoDemissao;

    public void demitirFuncionario(Funcionario funcionario) {
	eventoDemissao.fire(funcionario);
    }
}
