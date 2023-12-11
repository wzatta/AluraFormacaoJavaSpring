package com.estudojava.screenmatch.modelo;

import com.estudojava.screenmatch.calculos.Classificavel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Filme extends Titulo implements Classificavel {

	private String diretor;
	
	public Filme(String nome, int anoDeLancamento, boolean incluidoNoPlano, int duracaoEmMinutos, String diretor) {
		super(nome, anoDeLancamento, incluidoNoPlano, duracaoEmMinutos);
		this.diretor = diretor;
	}
	
	public int getClassficacao() {
		return (int) this.pegaMediaAvaliacoes();
	}

	
	
}
