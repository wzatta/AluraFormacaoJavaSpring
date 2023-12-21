package com.cilazatta.vollMed.services.validadores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseConsultaDTO;
import com.cilazatta.vollMed.entities.interfaces.ValidadorAgendamentoDeConsulta;
import com.cilazatta.vollMed.enums.HorariosDeConsultas;

@Component
public class ConsultaValidarHorarioDeAntecendenciaParaMarcarConsultaParaMesmoDia
		implements ValidadorAgendamentoDeConsulta {

	@Override
	public ResponseConsultaDTO validar(AgendamentoDeConsultaDTO dto) {
		if (dto.dataDaConsulta().isEqual(LocalDate.now())) {
			if (!this.converteEmumEmHoras(dto.horario())) {
				return new ResponseConsultaDTO(false,
						"Consulta deverá ser marcada com no minimo 1 hora de Antecedencia", null);
			}
		}
				return new ResponseConsultaDTO(true,"",null);
	}
	
	public Boolean converteEmumEmHoras(HorariosDeConsultas horaEnum) {
		// Este metodo converte o enum para horas e verifica se esta hora convertida é maior ou igual a 1 hora do horario atual.
				DateTimeFormatter horarioEnum = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime horario = LocalTime.parse(horaEnum.getHorario(), horarioEnum);
				if (horario.isAfter(LocalTime.now())) {
					int difHorario = horario.getHour() - LocalTime.now().getHour();
					if (difHorario >= 1) {
						return true;
					}
				}
				return false;
			}
	
	
}