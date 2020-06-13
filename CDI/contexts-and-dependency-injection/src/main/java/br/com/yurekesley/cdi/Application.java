package br.com.yurekesley.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Application {

    @PostConstruct
    public void init() {
	System.out.println("init CDI DemoBean");
    }

    public String getText() {
	return "CDI Is Workings";
    }
}
