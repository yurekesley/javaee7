package br.com.yurekesley.feature.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.yurekesley.model.Funcionario;
// TODO remover o acoplamento da criacao do evento, usar delegante no GerenciadorFuncionarioBean
public class GerenciadorFuncionarioBean {

    @Inject
    @Contratacao
    private Event<Funcionario> eventoContratacao;

    @Inject
    @Demissao
    private Event<Funcionario> eventoDemissao;

    public void cadastrarFuncionario(Funcionario funcionario) {
	funcionario.setAtivo(true);
	// entityManager.persist(funcionario);
	eventoContratacao.fire(funcionario); // fire, mesmo que emit do angular
    }

    public void demitirFuncionario(Funcionario funcionario) {
	funcionario.setAtivo(true);
	// entityManager.persist(funcionario);
	eventoDemissao.fire(funcionario); // fire, mesmo que emit do angular
    }

}
