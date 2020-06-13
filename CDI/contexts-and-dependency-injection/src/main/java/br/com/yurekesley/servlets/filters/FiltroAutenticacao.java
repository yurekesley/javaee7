package br.com.yurekesley.servlets.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

//@WebFilter("/*")
public class FiltroAutenticacao implements Filter {

    @Inject
    private Logger logger;

    @Override
    public void doFilter(ServletRequest request,
	    ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();
	Object usuario = session.getAttribute("usuarioLogado");

	String paginaDeLogin = "login.jsf";
	String paginaAtual = req.getRequestURI();

	if (usuario == null && !paginaAtual.endsWith(paginaDeLogin)) {
	    logger.info("usuário não autenticado");
	    ((HttpServletResponse) response).sendRedirect(paginaDeLogin);
	} else {
	    chain.doFilter(request, response);
	    logger.info("terminando requisição para " + paginaAtual);
	}
    }

    public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub

    }

    public void destroy() {
	// TODO Auto-generated method stub

    }

}
