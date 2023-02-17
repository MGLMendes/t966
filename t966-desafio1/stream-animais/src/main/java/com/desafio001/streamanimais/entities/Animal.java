package com.desafio001.streamanimais.entities;

import com.desafio001.streamanimais.entities.enums.Alimentacao;
import com.desafio001.streamanimais.entities.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Animal {

    private String nome;

    private Tipo tipo;
    private Double peso;
    private Alimentacao alimentacao;
    private Integer patas;

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", peso=" + peso + "kg" +
                ", alimentacao=" + alimentacao +
                ", patas=" + patas +
                '}';
    }
}


