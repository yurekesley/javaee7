package br.com.yurekesley.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements IAction {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
	return "forward:LoginForm.jsp";
    }

}
