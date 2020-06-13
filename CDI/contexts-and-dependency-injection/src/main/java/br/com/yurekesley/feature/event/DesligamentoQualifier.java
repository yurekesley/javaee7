package br.com.yurekesley.feature.event;

import javax.enterprise.util.AnnotationLiteral;

import br.com.yurekesley.model.TipoDesligamento;

public abstract class DesligamentoQualifier extends AnnotationLiteral<Desligamento>
	implements Desligamento {
    private TipoDesligamento tipoDesligamento;

    public DesligamentoQualifier(TipoDesligamento tipoDesligamento) {
	this.tipoDesligamento = tipoDesligamento;
    }

    public TipoDesligamento value() {
	return tipoDesligamento;
    }

}