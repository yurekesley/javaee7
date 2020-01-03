package br.com.yurekesley.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double salarioBase;
    private Escolaridade escolaridade;
}
