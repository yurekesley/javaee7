package br.com.yurekesley.feature.lookup;

import javax.enterprise.util.AnnotationLiteral;

import br.com.yurekesley.annotations.Simulador;
import br.com.yurekesley.model.PlanoDeCargos;

public class SimuladorQualifier extends AnnotationLiteral<Simulador> implements Simulador {

    private static final long serialVersionUID = 1L;

    public PlanoDeCargos planoDeCargos;

    public boolean planoAprovado;

    public boolean enviarNotificacao;

    public SimuladorQualifier(PlanoDeCargos planoDeCargos, boolean planoAprovado, boolean enviarNotificacao) {
	this.planoDeCargos = planoDeCargos;
	this.planoAprovado = planoAprovado;
	this.enviarNotificacao = enviarNotificacao;
    }

    public SimuladorQualifier() {
	this(PlanoDeCargos.VERSAO_2005, true, true);
    }

    public PlanoDeCargos planoDeCargos() {
	return this.planoDeCargos;
    }

    public boolean planoAprovado() {
	return this.planoAprovado;
    }

    public boolean enviarNotificacao() {
	return this.enviarNotificacao;
    }

}
