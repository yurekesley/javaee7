package br.com.yurekesley.feature.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import org.slf4j.Logger;

/**
 * Usando o padrão Decorator para subistituição de herança por composição
 * 
 * */

/**
 * @Decorator Ignora todos os @Default e injeta atraves da priridade
 * @Delegate é uma dependencia qualquer, buncando um bean elegível por qualificadores, sendo @Defaul, @Any, ou qualquer outro customizado obviamente, nesse
 *           ponoto de injecao, so pode haver um candidato para evitar embiguidade.
 **/

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class DecoratorChild implements IDecorator {

    @Inject
    @Delegate
    private IDecorator delegate;

    @Inject
    private Logger logger;

    // delega a execucao para o bean elegível de IDecorator
    // no caso DecoratorParent
    @Override
    public void method() {
	delegate.method();
    }

}
