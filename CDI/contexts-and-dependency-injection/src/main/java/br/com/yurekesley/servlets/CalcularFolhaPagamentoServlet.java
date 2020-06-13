package br.com.yurekesley.servlets;

import static br.com.yurekesley.model.PlanoDeCargos.VERSAO_2013;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.annotations.Simulador;
import br.com.yurekesley.model.Folha;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.builder.FuncionarioBuilder;
import br.com.yurekesley.service.folha_pagamento.CalculadoraFolhaPagamento;

@WebServlet("/folha-pagamento")
public class CalcularFolhaPagamentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject // @Default implicito// CalculadoraFolhaPagamentoReal
    private CalculadoraFolhaPagamento calculadoraFolha;

    @Inject
    @Simulador
    private CalculadoraFolhaPagamento calculadoraFolha_implementacao_versao2005;

    @Inject
    @Simulador(planoDeCargos = VERSAO_2013)
    private CalculadoraFolhaPagamento calculadoraFolha_implementacao_versao2013;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {

	FuncionarioBuilder builder = new FuncionarioBuilder();

	Funcionario f1 = builder.comSalarioBaseDe(1000.0).build();
	Funcionario f2 = builder.comSalarioBaseDe(2000.0).build();
	Funcionario f3 = builder.comSalarioBaseDe(3000.0).build();

	List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3);

	Folha folha = calculadoraFolha.calculaFolha(funcionarios);

	res.getOutputStream().print("Calculo da folha executado com sucesso");
	System.out.println("Fim.");

    }

}
