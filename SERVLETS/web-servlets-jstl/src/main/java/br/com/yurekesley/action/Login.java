package br.com.yurekesley.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements IAction {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

	String login = request.getParameter("login");
	String password = request.getParameter("password");

	return "forward:LoginForm.jsp";
    }

}
