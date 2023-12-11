package com.estudojava.screenmatch.modelo;

import com.estudojava.screenmatch.calculos.Classificavel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Episodio implements Classificavel {

	private int numero;
	private String nome;
	private Serie serie;
	private int totalVisualizacao;

	@Override
	public int getClassficacao() {
		if (this.totalVisualizacao > 100) {
			return 4;
		} else {
			return 2;
		}

	}
}
