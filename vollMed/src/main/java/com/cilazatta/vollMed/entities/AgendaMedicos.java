package com.cilazatta.vollMed.entities;

import java.time.LocalDate;
import java.util.Map;

import com.cilazatta.vollMed.enums.HorariosDeConsultas;

public class AgendaMedicos {
	
	private Long id;
	private CadastroDeMedicos medico;
	private LocalDate data;
	private Map<HorariosDeConsultas, CadastroDePaciente> compromisso;

}
