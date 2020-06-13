package br.com.yurekesley.feature.lookup;

import java.io.IOException;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lookup")
public class LookupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject @Any
    private Instance<ILookup> instance;

    protected void doGet(HttpServletRequest req,
	    HttpServletResponse res)
	    throws ServletException, IOException {
	
	
	    // executar alguma lógica de negócio e escolher o bean programaticamente
		
	    Instance<ILookup> iLookup =
		    instance.select(new SimuladorQualifier(){});
	res.getOutputStream()
		.print(iLookup.get().getClass().getName());
    }

}
