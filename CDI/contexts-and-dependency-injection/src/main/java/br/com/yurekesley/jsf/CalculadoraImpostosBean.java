package br.com.yurekesley.jsf;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.builder.FuncionarioBuilder;
import br.com.yurekesley.service.impostos.CalculadoraDeImpostos;
import lombok.Data;

@Named
public @Data class CalculadoraImpostosBean {

    @Inject
    private CalculadoraDeImpostos calculadoraImpostos;
    private double salarioBase;
    private double imposto;

    public void calculaImposto() {
	Funcionario funcionario = new FuncionarioBuilder()
		.comSalarioBaseDe(salarioBase)
		.build();
	System.out.println("Efetuando o cálculo.");
	imposto = calculadoraImpostos.calculaImpostoDeRenda(funcionario);
	System.out.println("Fim.");
    }

}
