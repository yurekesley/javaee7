package br.com.yurekesley.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    public Cargo(Double salarioBase, Escolaridade escolaridade) {
	this.salarioBase = salarioBase;
	this.escolaridade = escolaridade;
    }

    private Double salarioBase;
    private Escolaridade escolaridade;
}
