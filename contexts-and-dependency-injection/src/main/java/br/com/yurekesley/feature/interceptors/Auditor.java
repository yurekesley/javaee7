package br.com.yurekesley.feature.interceptors;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public @Auditavel class Auditor {

    @Inject
    private Logger logger;

    @AroundInvoke // @AroundTimeout usado em @Schedule ou @Timer (EJBs)
    public Object auditar(InvocationContext context) throws Exception {
	Method method = context.getMethod();
	Object target = context.getTarget();
	Object[] params = context.getParameters();

	logger.info("chama método original");

	Object retorno = context.proceed();

	logger.info(String.format("auditando o método: '%s' "
		+ "do objeto: '%s' "
		+ "com os parâmetros: '%s'", method, target, params));

	return retorno;

    }

    @AroundConstruct
    public void interceptaConstrutor(InvocationContext context)
	    throws Exception {
	context.proceed();
	Object objetoRecemCriado = context.getTarget();

	logger.info("@AroundConstruct");
	logger.info(objetoRecemCriado.toString());

    }

    @PostConstruct
    public void postConstruct(InvocationContext context)
	    throws Exception {
	Object target = context.getTarget();

	logger.info("@PostConstruct");
	logger.info(target.toString());

	context.proceed();
    }

    @PreDestroy
    public void preDestroy(InvocationContext context) throws Exception {
	Object target = context.getTarget();

	logger.info("@PreDestroy");
	logger.info(target.toString());

	context.proceed();

    }

}
