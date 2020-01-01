package br.com.yurekesley.feature.specializes;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/specializes")
public class SpecializesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    ISpecializes iSpecializes;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {

	res.getOutputStream()
		.print(iSpecializes.getClass().getName());
    }
}
