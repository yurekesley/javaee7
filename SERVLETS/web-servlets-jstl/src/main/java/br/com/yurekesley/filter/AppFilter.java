package br.com.yurekesley.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class AppFilter implements Filter {

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}
