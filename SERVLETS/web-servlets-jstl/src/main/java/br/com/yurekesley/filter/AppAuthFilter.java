package br.com.yurekesley.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AppAuthFilter extends AppFilter {

    private static Set<String> excluded = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	String excludedString = filterConfig.getInitParameter("exclude");
	if (excludedString != null) {
	    excluded = Collections.unmodifiableSet(
		    new HashSet<>(Arrays.asList(excludedString.split(",", 0))));
	} else {
	    excluded = Collections.<String> emptySet();
	}
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	

	String path = request.getRequestURI().substring(request.getContextPath().length());

	HttpSession sessao = request.getSession();
	boolean usuarioNaoEstaLogado = (sessao.getAttribute("user") == null);
	boolean ehUmaAcaoProtegida = !(path.equals("/Login") || path.equals("/LoginForm"));

	if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
	    response.sendRedirect("LoginForm");
	    return;
	}

	chain.doFilter(servletRequest, servletResponse);
    }

   
}
