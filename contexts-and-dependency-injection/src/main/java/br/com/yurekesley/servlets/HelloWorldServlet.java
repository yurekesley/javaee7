package br.com.yurekesley.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yurekesley.cdi.Application;

@WebServlet("/hello-world")
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Inject
    Application application;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	writer.println(PAGE_HEADER);
	writer.println("<h1>" +
		application.getText() +
		"</h1>");
	writer.println(PAGE_FOOTER);
	writer.close();
    }

}
