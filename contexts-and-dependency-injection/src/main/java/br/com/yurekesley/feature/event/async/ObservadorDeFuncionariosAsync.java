package br.com.yurekesley.feature.event.async;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

import br.com.yurekesley.feature.event.Desligamento;
import br.com.yurekesley.model.Funcionario;
import br.com.yurekesley.model.TipoDesligamento;

@Stateless
public class ObservadorDeFuncionariosAsync {

    @Asynchronous
    public void observaDemissaoFuncionario(@Observes @Desligamento(TipoDesligamento.DEMISSAO) Funcionario funcionario, Logger logger,
	    EventMetadata eventMetadata) {
	logger.info("Recebendo evento do funcionario {}", funcionario);
	InjectionPoint injectionPoint = eventMetadata.getInjectionPoint();
	if (injectionPoint != null) {
	    logger.info("Evento disparado por {}",
		    injectionPoint.getMember());
	}
    }
}
