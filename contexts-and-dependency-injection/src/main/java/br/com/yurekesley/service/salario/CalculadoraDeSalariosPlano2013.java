package br.com.yurekesley.service.salario;

import javax.enterprise.inject.Alternative;

import br.com.yurekesley.model.Funcionario;

@Alternative
public class CalculadoraDeSalariosPlano2013 implements CalculadoraDeSalarios {

    public double calculaSalario(Funcionario funcionario) {
	return 2013;
    }

}
