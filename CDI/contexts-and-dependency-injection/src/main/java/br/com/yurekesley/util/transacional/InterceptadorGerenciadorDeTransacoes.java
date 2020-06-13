package br.com.yurekesley.util.transacional;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.yurekesley.annotations.Transacional;

@Interceptor
@Transacional
public class InterceptadorGerenciadorDeTransacoes {

    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object gerenciaTransacao(InvocationContext context)
	    throws Exception {
	EntityTransaction tx = null;
	try {
	    // em ambiente JTA apenas o getTransaction já lança exceção
	    tx = entityManager.getTransaction();
	    tx.begin();
	    Object retorno = context.proceed();
	    tx.commit();
	    return retorno;
	} catch (RuntimeException e) {
	    if (tx != null)
		tx.rollback();
	    throw e;
	}
    }

}
