package br.com.yurekesley.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    public Funcionario(Cargo cargo, Escolaridade escolaridade, Double salarioBase) {
	this.cargo = cargo;
	this.escolaridade = escolaridade;
	this.salarioBase = salarioBase;
    }

    private Integer id;
    private String nome;
    private Double salarioBase;
    private Escolaridade escolaridade;

    private Cargo cargo;

}
