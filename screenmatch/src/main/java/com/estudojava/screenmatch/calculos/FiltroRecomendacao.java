package com.estudojava.screenmatch.calculos;

public class FiltroRecomendacao {
	
	public void filtra(Classificavel classificavel) {
		if(classificavel.getClassficacao()>=4) {
			System.out.println("Esta entre os preferidos do momento");
		} else if(classificavel.getClassficacao()>=2) {
			System.out.println("Muito bem avaliado no momento!");
		} else {
			System.out.println("Coloque na Sua Lista para Assistir depois");
		}
	}

}
