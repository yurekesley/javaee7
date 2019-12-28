package br.com.yurekesley.service.folha_pagamento;

import java.util.List;

import br.com.yurekesley.model.Folha;
import br.com.yurekesley.model.Funcionario;

public class CalculadoraFolhaPagamentoReal implements CalculadoraFolhaPagamento {

    public Folha calculaFolha(List<Funcionario> funcionarios) {
	System.out.println("Efetua o cálculo real da folha de pagamentos");
	return null;
    }

}
