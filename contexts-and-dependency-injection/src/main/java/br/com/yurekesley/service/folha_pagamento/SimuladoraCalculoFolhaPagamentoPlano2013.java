package br.com.yurekesley.service.folha_pagamento;

import static br.com.yurekesley.model.PlanoDeCargos.*;

import java.util.List;

import br.com.yurekesley.annotations.Simulador;
import br.com.yurekesley.model.Folha;
import br.com.yurekesley.model.Funcionario;

@Simulador(planoDeCargos = VERSAO_2013)
public class SimuladoraCalculoFolhaPagamentoPlano2013 implements CalculadoraFolhaPagamento {

    public Folha calculaFolha(List<Funcionario> funcionarios) {
	System.out.println("Simulação com plano de 2013");
	return null;
    }

}
