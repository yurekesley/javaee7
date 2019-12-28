package br.com.yurekesley.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.annotations.Calculadora;
import br.com.yurekesley.service.salario.CalculadoraDeSalarios;

@WebServlet("/calculadora-salarios")
public class CalculadoraDeSalariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject 
    CalculadoraDeSalarios calculadoraDeSalarios;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {

	res.getOutputStream()
		.print("Calculadora: " + calculadoraDeSalarios.getClass());
    }

}
