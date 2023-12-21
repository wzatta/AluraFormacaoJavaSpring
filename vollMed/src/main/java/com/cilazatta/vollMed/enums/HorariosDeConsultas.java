package com.cilazatta.vollMed.enums;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum HorariosDeConsultas {

	HOR01("07:30"),
	HOR02("08:30"),
	HOR03("09:30"),
	HOR04("10:30"),
	HOR05("11:30"),
	HOR06("13:30"),
	HOR07("14:30"),
	HOR08("15:30"),
	HOR09("16:30"),
	HOR10("17:30");
	
	private final String horario;
	private List<String> listaHorario;
	
	HorariosDeConsultas(String horario){
		this.horario = horario;
	}

	public String getHorario() {
		return this.horario;
	}
	
	public List<String> getListaHorarios(){
		for(HorariosDeConsultas horario : HorariosDeConsultas.values()) {
			this.listaHorario.add(horario.getHorario());
		}
		return this.listaHorario;
	}

}
