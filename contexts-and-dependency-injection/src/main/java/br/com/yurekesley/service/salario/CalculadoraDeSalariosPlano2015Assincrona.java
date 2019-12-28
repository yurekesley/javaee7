package br.com.yurekesley.service.salario;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.yurekesley.annotations.Calculadora;

@Calculadora
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class CalculadoraDeSalariosPlano2015Assincrona extends CalculadoraDeSalariosPlano2015 {

}
