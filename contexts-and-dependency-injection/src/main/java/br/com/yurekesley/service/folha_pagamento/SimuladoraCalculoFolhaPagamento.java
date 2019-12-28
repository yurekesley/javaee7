package br.com.yurekesley.service.folha_pagamento;

import java.util.List;

import br.com.yurekesley.annotations.Simulador;
import br.com.yurekesley.model.Folha;
import br.com.yurekesley.model.Funcionario;

@Simulador
public class SimuladoraCalculoFolhaPagamento implements CalculadoraFolhaPagamento {

    public Folha calculaFolha(List<Funcionario> funcionarios) {
	System.out.println("Efetua o simulacao da folha de pagamentos");
	return null;
    }
}
