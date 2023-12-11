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
@ToString(callSuper = true)
public class Serie extends Titulo  {
	private int temporadas;
	private boolean isAtiva;
	private int episodiosPorTemporada;
	private int minutosPorEpisodio;
	
	@Override
	public int getDuracaoEmMinutos() {
		return temporadas * episodiosPorTemporada * minutosPorEpisodio;
	}


}
