package br.com.yurekesley.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.service.FolhaService;
import br.com.yurekesley.service.FuncionarioService;

@WebServlet("/dao-test")
public class DaoTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    FolhaService folhaService;

    @Inject
    FuncionarioService funcionarioService;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {
	
	folhaService.findAll();
	funcionarioService.findAll();

	res.getOutputStream()
		.print(folhaService.getClass().getName());

	res.getOutputStream()
		.print(funcionarioService.getClass().getName());

    }

}
