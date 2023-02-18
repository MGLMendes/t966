package com.desafio001.streamanimais.service;

import com.desafio001.streamanimais.entities.Animal;
import com.desafio001.streamanimais.entities.enums.Alimentacao;
import com.desafio001.streamanimais.entities.enums.Tipo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
@Service
public class AnimalService {
    public List<Animal> animaisPorTipo(List<Animal> animais, Tipo mamifero) {
        Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
                animal.getTipo() == mamifero);

        return listaDeAnimais.toList();
    }

    public List<Animal> animaisPorAlimentacaoNaoTipos(List<Animal> animais, Alimentacao carnivoro, Tipo aves) {
        Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
                animal.getAlimentacao() == carnivoro && animal.getTipo() != aves);

        return listaDeAnimais.toList();
    }

    public List<Animal> animaisPorAlimentacaoEPesoMaiorQue(List<Animal> animais, Alimentacao herbivoro, double v) {
        Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
                animal.getPeso() >= v && animal.getAlimentacao() == herbivoro);

        return listaDeAnimais.toList();
    }
}
