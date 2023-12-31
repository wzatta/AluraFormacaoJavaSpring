package com.estudojava.screenmatch;

import com.estudojava.screenmatch.calculos.CalculadoraDeTempo;
import com.estudojava.screenmatch.calculos.FiltroRecomendacao;
import com.estudojava.screenmatch.modelo.Episodio;
import com.estudojava.screenmatch.modelo.Filme;
import com.estudojava.screenmatch.modelo.Serie;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		
		Filme marvel = new Filme("Os Vingadores", 2020, true, 180,"waldyr");
		marvel.avalia(100);
		marvel.avalia(80);
		marvel.avalia(1);
		marvel.avalia(4);
		marvel.avalia(0);
		marvel.avalia(2);
		marvel.avalia(3);
		
		marvel.exibiFichaTecnica();
		marvel.imprimeAvaliacoes();
		marvel.imprimeMediaAvaliacoes();
		filtro.filtra(marvel);
		
		Filme meuFilme = new Filme();
		meuFilme.setNome("Gladiador");
		meuFilme.setDiretor("Matheus");
		meuFilme.setAnoDeLancamento(2000);
		meuFilme.setDuracaoEmMinutos(140);
		meuFilme.setIncluidoNoPlano(true);
		
		meuFilme.avalia(8);
		meuFilme.avalia(1);
		meuFilme.avalia(10);
		
		meuFilme.exibiFichaTecnica();
		meuFilme.imprimeAvaliacoes();
		meuFilme.imprimeMediaAvaliacoes();;
		filtro.filtra(meuFilme);
		
		Filme favorito = new Filme();
		favorito.setNome("The Matrix");;
		favorito.setDiretor("WALDYR ZATTA");
		favorito.setAnoDeLancamento(1999);
		favorito.setDuracaoEmMinutos(135);
		favorito.setIncluidoNoPlano(true);
       
        favorito.avalia(8);
        favorito.avalia(-1);
        favorito.avalia(10);
        
        favorito.exibiFichaTecnica();
        favorito.imprimeAvaliacoes();
        favorito.imprimeMediaAvaliacoes();;
        filtro.filtra(favorito);
        
        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        
        lost.avalia(1);
        lost.avalia(2);
        lost.avalia(3);
        
        lost.exibiFichaTecnica();
        lost.imprimeMediaAvaliacoes();;
        System.out.println(lost.getDuracaoEmMinutos());
        
        Episodio lost1 = new Episodio();
        lost1.setNome("Onde tudo começou");
        lost1.setNumero(1);
        lost1.setSerie(lost);
        lost1.setTotalVisualizacao(300);
        
        CalculadoraDeTempo calc = new CalculadoraDeTempo();
        calc.inclui(meuFilme);
        calc.inclui(marvel);
        calc.inclui(favorito);
        calc.inclui(lost);
        calc.imprimeMaratona();
	}
}
