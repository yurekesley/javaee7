package br.com.yurekesley.feature.event;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

// TODO remover o acoplamento da criacao do evento, usar delegante no GerenciadorFuncionarioBean
public class GerenciadorFuncionarioBeanComQualificadorDinamicoComParametro {

    private TipoDesligamento tipoDesligamento = TipoDesligamento.APOSENTADORIA;

    @Inject
    private Event<Funcionario> eventoDesligamento;

    public void desligamento(Funcionario funcionario) {
	funcionario.setAtivo(true);

	Annotation qualificador = null;

	if (tipoDesligamento == TipoDesligamento.APOSENTADORIA) {
	    qualificador = new DesligamentoQualifier(TipoDesligamento.APOSENTADORIA) {
	    };
	}

	else if (tipoDesligamento == TipoDesligamento.DEMISSAO) {
	    qualificador = new DesligamentoQualifier(TipoDesligamento.DEMISSAO) {
	    };
	}
	Event<Funcionario> eventoQualificado = eventoDesligamento
		.select(qualificador);
	eventoQualificado.fire(funcionario);
    }

}
