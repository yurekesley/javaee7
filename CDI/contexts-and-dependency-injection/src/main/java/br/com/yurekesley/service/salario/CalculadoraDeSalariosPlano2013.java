package br.com.yurekesley.service.salario;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.yurekesley.model.Funcionario;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class CalculadoraDeSalariosPlano2013 implements CalculadoraDeSalarios {
 
    public double calculaSalario(Funcionario funcionario) {
	return 2013.0;
    }

}
