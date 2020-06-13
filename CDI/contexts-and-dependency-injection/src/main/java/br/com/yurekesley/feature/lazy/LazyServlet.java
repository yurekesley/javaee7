package br.com.yurekesley.feature.lazy;

import java.io.IOException;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LazyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Instance<ILazy> instance;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {

	ILazy iLazy = instance.get(); // a insanciação é feita aqui

	res.getOutputStream()
		.print(iLazy.getClass().getName());
    }

}
