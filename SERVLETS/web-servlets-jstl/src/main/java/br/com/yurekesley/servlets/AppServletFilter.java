package br.com.yurekesley.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.action.IAction;
import br.com.yurekesley.filter.AppFilter;

public class AppServletFilter extends AppFilter {

    private static final String DEFAULT_PACKAGE_ACTION = "br.com.yurekesley.action.";

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

	if (isExcluded(request)) {
	    chain.doFilter(request, response);
	    return;
	}

	String path = request.getRequestURI().substring(request.getContextPath().length());

	String nome;
	try {
	    Class<?> classe = Class.forName(DEFAULT_PACKAGE_ACTION + path.split("/")[1]);
	    IAction action = (IAction) classe.newInstance();
	    nome = action.execute(request, response);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    throw new ServletException(e);
	}

	String[] tipoEEndereco = nome.split(":");
	if (tipoEEndereco[0].equals("forward")) {
	    String page = "/view/" + tipoEEndereco[1];

	    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    dispatcher.forward(request, response);

	} else {
	    response.sendRedirect(tipoEEndereco[1]);
	}

    }

    boolean isExcluded(HttpServletRequest request) {
	String path = request.getRequestURI();
	String extension = path.substring(path.indexOf('.', path.lastIndexOf('/')) + 1).toLowerCase();
	return excluded.contains(extension);
    }

}
