package com.desafio001.streamanimais;

import com.desafio001.streamanimais.entities.Animal;
import com.desafio001.streamanimais.entities.enums.Alimentacao;
import com.desafio001.streamanimais.entities.enums.Tipo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamAnimaisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamAnimaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Animal cachorro = new Animal("Cachorro",Tipo.MAMIFERO, 7.0, Alimentacao.CARNIVORO, 4);
		Animal elefante = new Animal("Elefante",Tipo.MAMIFERO, 4000.0, Alimentacao.HERBIVORO, 4);
		Animal cavalo = new Animal("Cavalo",Tipo.MAMIFERO, 420.0, Alimentacao.HERBIVORO, 4);
		Animal salmao = new Animal("Salmao",Tipo.PEIXE, 4.2, Alimentacao.CARNIVORO, 0);
		Animal aguia = new Animal("Aguia",Tipo.AVES, 6.3, Alimentacao.CARNIVORO, 2);
		Animal porco = new Animal("Porco",Tipo.MAMIFERO, 75.0, Alimentacao.ONIVOROS, 4);
		Animal lagarto = new Animal("Lagarto",Tipo.REPTEIS, 4.0, Alimentacao.HERBIVORO, 4);

		Tipo tipo = Tipo.MAMIFERO;
		Alimentacao alimentacao = Alimentacao.HERBIVORO;

		List<Animal> animais = new ArrayList<>(List.of(cachorro, elefante, cavalo, salmao, aguia, porco, lagarto));
		System.out.println();
		System.out.println("Animais por alimentação " + alimentacao + " e não por tipo " + tipo);
		List<Animal> filtro1 = animaisPorAlimentacaoEPesoMaiorQue(animais, Alimentacao.HERBIVORO, 100.0);
		System.out.println(filtro1);
		System.out.println();
		alimentacao = Alimentacao.CARNIVORO;
		tipo = Tipo.AVES;
		System.out.println("Animais por alimentação " + alimentacao + " e não por tipo " + tipo);
		List<Animal> filtro2 = animaisPorAlimentacaoNaoTipos(animais, Alimentacao.CARNIVORO, Tipo.AVES);
		System.out.println(filtro2);
		List<Animal> filtro3 = animaisPorTipo(animais, tipo);
		System.out.println();
		System.out.println("Animais por tipo: " + tipo);
		System.out.println(filtro3);
	}

	private List<Animal> animaisPorTipo(List<Animal> animais, Tipo mamifero) {
		Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
				animal.getTipo() == mamifero);

		return listaDeAnimais.toList();
	}

	private List<Animal> animaisPorAlimentacaoNaoTipos(List<Animal> animais, Alimentacao carnivoro, Tipo aves) {
		Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
				animal.getAlimentacao() == carnivoro && animal.getTipo() != aves);

		return listaDeAnimais.toList();
	}

	private List<Animal> animaisPorAlimentacaoEPesoMaiorQue(List<Animal> animais, Alimentacao herbivoro, double v) {
		Stream<Animal> listaDeAnimais = animais.stream().filter(animal ->
				animal.getPeso() >= v && animal.getAlimentacao() == herbivoro);

		return listaDeAnimais.toList();
	}
}
