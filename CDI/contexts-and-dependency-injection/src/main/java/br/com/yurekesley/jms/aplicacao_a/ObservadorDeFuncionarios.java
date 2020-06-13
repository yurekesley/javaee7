package br.com.yurekesley.jms.aplicacao_a;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

import org.slf4j.Logger;

import br.com.yurekesley.feature.event.Desligamento;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

/*
 * Captura evento e localmente, e envia para a Fila, 
 * */

@Stateless
public class ObservadorDeFuncionarios {

    @Inject
    private JMSContext jmsContext;

    @Resource(mappedName = "java:/jms/topic/demissaoTopic")
    private Topic topicoDemissao;

    @Asynchronous
    public void notificaAgenciaDeEmprego(
	    @Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger) throws Exception {
	logger.info("Enviando o(a) {} para agencia de empregos", funcionario);
	jmsContext.createProducer().send(topicoDemissao, funcionario);
    }

}
