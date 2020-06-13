package br.com.yurekesley.service.salario;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.yurekesley.model.Funcionario;

@Alternative
@Priority(Interceptor.Priority.APPLICATION + 1)
public class CalculadoraDeSalariosPlano2014 implements CalculadoraDeSalarios {

    public double calculaSalario(Funcionario funcionario) {
	return 2014.0;
    }

}
