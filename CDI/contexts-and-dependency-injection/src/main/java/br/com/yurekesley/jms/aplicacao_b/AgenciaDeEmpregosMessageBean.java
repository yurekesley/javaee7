package br.com.yurekesley.jms.aplicacao_b;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;

import br.com.yurekesley.feature.event.Demissao;
import br.com.yurekesley.model.Funcionario;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/demissaoTopic"),
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class AgenciaDeEmpregosMessageBean implements MessageListener {

    @Inject
    @Demissao
    private Event<Funcionario> eventoDemissao;

    @Inject
    private Logger logger;

    public void onMessage(Message message) {
	try {

	    Thread.sleep(5000);

	    Funcionario funcionario = message.getBody(Funcionario.class);
	    logger.info("Recebida a demissão do funcionario {} via JMS", funcionario);

	    eventoDemissao.fire(funcionario);

	} catch (JMSException ex) {
	    logger.error("Erro ao ler a mensagem via JMS", ex);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}
