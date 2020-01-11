package br.com.yurekesley.jms.aplicacao_a;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.model.Funcionario;

/**
 * Servlet implementation class AplicacaoAServlet
 */
@WebServlet("/aplicacaoAServlet")
public class AplicacaoAServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private GerenciadorFuncionarioBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	bean.demitirFuncionario(new Funcionario()	);

	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
