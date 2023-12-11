package com.estudojava.screenmatch.calculos;

import java.util.ArrayList;
import java.util.List;

import com.estudojava.screenmatch.modelo.Titulo;

public class CalculadoraDeTempo {
	private int tempoTotal;
	private List<String> titulos = new ArrayList<>();
	
	public int getTempototal() {
		return tempoTotal;
	}
	
	public void inclui(Titulo titulo) {
		this.tempoTotal += titulo.getDuracaoEmMinutos();
		this.titulos.add(titulo.getNome());
	}
	
	public void imprimeMaratona() {
		System.out.println("Tempo de Maratona com meus titulos Preferido : " + this.tempoTotal + "Minutos");
		this.titulos.stream()
		.forEach(r-> System.out.print("( "+r+" )"));
	}
	

}
