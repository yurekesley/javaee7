package br.com.yurekesley.jms.aplicacao_b;

import javax.enterprise.event.Observes;

import org.slf4j.Logger;

import br.com.yurekesley.feature.event.Demissao;
import br.com.yurekesley.model.Funcionario;

public class AgenciaDeEmpregosObserves {

    public void ajudarFuncionarioDemitido(
	    @Observes @Demissao Funcionario funcionario, Logger logger) {
	logger.info("Apliciação B - Ajudando {} a conseguir um novo emprego", funcionario);

    }
}
