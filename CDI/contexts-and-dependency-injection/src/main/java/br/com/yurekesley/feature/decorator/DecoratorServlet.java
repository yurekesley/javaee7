package br.com.yurekesley.feature.decorator;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/decorator")
public class DecoratorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Inject IDecorator 	iDecorator;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {
	
	iDecorator.method();

    }

}
