package br.com.yurekesley.service.salario;

import br.com.yurekesley.annotations.Calculadora;
import br.com.yurekesley.model.Funcionario;

@Calculadora
public class CalculadoraDeSalariosPlano2015 implements CalculadoraDeSalarios {

    public double calculaSalario(Funcionario funcionario) {
	return 2015.0;
    }

}
