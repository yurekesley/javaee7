package br.com.yurekesley.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.model.Cargo;
import br.com.yurekesley.model.Escolaridade;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.service.salario.CalculadoraDeSalarios;

@WebServlet("/calculadora-salarios")
public class CalculadoraDeSalariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    CalculadoraDeSalarios calculadoraDeSalarios;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse resp)
	    throws ServletException, IOException {

	Cargo cargo = new Cargo(1.2, Escolaridade.MEDIO);
	double salario = calculadoraDeSalarios.calculaSalario(new Funcionario(cargo, Escolaridade.MEDIO, 1.5));

	resp.getOutputStream().print("Salário Calculado: " + salario);

    }

}
