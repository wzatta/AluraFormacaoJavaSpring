package com.cilazatta.vollMed;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Schema.Printer;

import com.cilazatta.vollMed.entities.AgendamentoDeConsultas;
import com.cilazatta.vollMed.enums.HorariosDeConsultas;

public class Principal {

	public static void main(String[] args) {
		AgendamentoDeConsultas agendar = new AgendamentoDeConsultas();
		List<String> horariosValue = new ArrayList<String>();;
		for(HorariosDeConsultas hora : HorariosDeConsultas.values()) {
			horariosValue.add(hora.toString());
		}
		horariosValue.stream().forEach(v-> System.out.println(v));
	}

}
