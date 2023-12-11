package com.estudojava.screenmatch.modelo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Titulo {

	private String nome;
	private int anoDeLancamento;
	private boolean incluidoNoPlano;
	private List<Double> avaliacoes = new ArrayList<Double>();
	private double somaDasAvaliacao;
	private int totalDeAvaliacoes;
	private int duracaoEmMinutos;
	
	public Titulo(String nome, int anoDeLancamento, boolean incluidoNoPlano, int duracaoEmMinutos) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
		this.incluidoNoPlano = incluidoNoPlano;
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	
	
	public void exibiFichaTecnica() {
		System.out.println(this.toString());
	}
	
	public void avalia(double nota) {
		double novaNota = 0.0;
		if(nota>5) {novaNota = 5;}
		else {
			if(nota < 0) {novaNota = 0;}
		 else {
			novaNota = nota;
		 }}
		this.avaliacoes.add(novaNota);
		this.somaDasAvaliacao +=novaNota;
		this.totalDeAvaliacoes++;
	}

	public void imprimeAvaliacoes() {
		System.out.print("Avaliações : ");
		this.avaliacoes.stream()
		.forEach(r-> System.out.print("( "+r+" ) "));
		System.out.println();
	}
	
	 double pegaMediaAvaliacoes() {
		return this.somaDasAvaliacao / this.totalDeAvaliacoes;
	}
	
	public void imprimeMediaAvaliacoes() {
		 System.out.println("Media de Avaliação = "+ this.pegaMediaAvaliacoes());
	}

	
	
	
}
