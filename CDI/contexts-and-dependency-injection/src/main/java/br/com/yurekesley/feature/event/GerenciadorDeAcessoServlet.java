package br.com.yurekesley.feature.event;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.model.Funcionario;

@WebServlet("/gerenciador-acesso-event")
public class GerenciadorDeAcessoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    GerenciadorFuncionarioBean bean;
    
    @Inject
    GerenciadorFuncionarioBeanComQualificadorDinamico beanComQualificadorDinamico;
    
    @Inject
    GerenciadorFuncionarioBeanComQualificadorDinamicoComParametro beanComQualificadorDinamicoComParametro;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciadorDeAcessoServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	bean.cadastrarFuncionario(new Funcionario());
	
	beanComQualificadorDinamico.desligamento(new Funcionario());
	
	beanComQualificadorDinamicoComParametro.desligamento(new Funcionario());

	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
