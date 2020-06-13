package br.com.yurekesley.feature.event;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

// TODO remover o acoplamento da criacao do evento, usar delegante no GerenciadorFuncionarioBean
public class GerenciadorFuncionarioBeanComQualificadorDinamico {

    private TipoDesligamento tipoDesligamento = TipoDesligamento.APOSENTADORIA;

    @Inject
    private Event<Funcionario> eventoDesligamento;

    public void desligamento(Funcionario funcionario) {
	funcionario.setAtivo(true);

	Annotation qualificador = null;

	if (tipoDesligamento == TipoDesligamento.APOSENTADORIA) {
	    qualificador = new AnnotationLiteral<Aposentadoria>() {
	    };
	}

	else if (tipoDesligamento == TipoDesligamento.DEMISSAO) {
	    qualificador = new AnnotationLiteral<Demissao>() {
	    };
	}
	Event<Funcionario> eventoQualificado = eventoDesligamento
		.select(qualificador);
	eventoQualificado.fire(funcionario);
    }

}
