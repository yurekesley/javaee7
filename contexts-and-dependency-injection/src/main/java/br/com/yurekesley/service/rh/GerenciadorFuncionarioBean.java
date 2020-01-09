package br.com.yurekesley.service.rh;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import br.com.yurekesley.model.Funcionario;

public class GerenciadorFuncionarioBean {

    @Inject
    @Any
    private Instance<GerenciadorDeAcesso> services;

    public void cadastrarFuncionario(Funcionario funcionario) {
	// lógica de ativação do funcionário
	funcionario.setAtivo(true);
	// entityManager.persist(funcionario);
	for (GerenciadorDeAcesso gerenciador : services) {
	    gerenciador.criaUsuario(funcionario);
	}
    }
}
