package br.com.yurekesley.service.folha_pagamento;

import java.util.List;

import br.com.yurekesley.model.Folha;
import br.com.yurekesley.model.Funcionario;

public interface CalculadoraFolhaPagamento {

    Folha calculaFolha(List<Funcionario> funcionarios);

}
