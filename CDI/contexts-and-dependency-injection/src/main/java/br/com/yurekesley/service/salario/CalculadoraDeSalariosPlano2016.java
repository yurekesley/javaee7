package br.com.yurekesley.service.salario;

import javax.enterprise.inject.Typed;

import br.com.yurekesley.model.Funcionario;

@Typed(CalculadoraDeSalarios.class)
public class CalculadoraDeSalariosPlano2016 implements CalculadoraDeSalarios {

    public double calculaSalario(Funcionario funcionario) {
	return 2015.0;
    }

}
