package br.com.yurekesley.util.transacional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.yurekesley.annotations.Transacional;
import br.com.yurekesley.model.Funcionario;

public class FuncionarioBean {
    @Inject
    private EntityManager em;

    @Transacional
    public void salvarFuncionario(Funcionario funcionario) {
	em.persist(funcionario);
    }
}