package br.com.yurekesley.feature.interceptors;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auditor")
public class AuditavelServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private AuditavelImpl instance;
    
    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {

	
	instance.metodoAuditado();
	
	res.getOutputStream()
		.print(instance.getClass().getName());
    }

}
