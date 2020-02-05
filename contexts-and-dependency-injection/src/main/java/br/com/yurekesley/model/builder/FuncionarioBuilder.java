package br.com.yurekesley.model.builder;

import java.util.Calendar;

import br.com.yurekesley.model.Cargo;
import br.com.yurekesley.model.Escolaridade;
import br.com.yurekesley.model.Funcionario;

public class FuncionarioBuilder {

    private int anoAdmissao;
    private Escolaridade escolaridadeFuncionario;
    private Escolaridade escolaridadeCargo;
    private Double salarioBase;

    public FuncionarioBuilder() {
	escolaridadeCargo = Escolaridade.SUPERIOR;
	escolaridadeFuncionario = Escolaridade.SUPERIOR;
	anoAdmissao = Calendar.getInstance().get(Calendar.YEAR);
    }

    public FuncionarioBuilder comSalarioBaseDe(double salarioBase) {
	this.salarioBase = salarioBase;
	return this;
    }

    public FuncionarioBuilder comComEscolariadade(Escolaridade escolaridade) {
	this.escolaridadeFuncionario = escolaridade;
	return this;
    }

    public Funcionario build() {

	Cargo cargo = new Cargo(salarioBase, escolaridadeCargo);

	return new Funcionario(cargo, escolaridadeCargo, salarioBase);
    }
}
