package br.com.yurekesley.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Disponibiliza a injção do Logger para para o ponto de injeção, ou seja , a classe que esta solicitando a injecao
 * 
 */
public class GenericLogger {

    private Logger logger = LoggerFactory.getLogger(GenericLogger.class);

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
	Class<?> classe = injectionPoint.getMember().getDeclaringClass();
	return LoggerFactory.getLogger(classe.getName());
    }
}
