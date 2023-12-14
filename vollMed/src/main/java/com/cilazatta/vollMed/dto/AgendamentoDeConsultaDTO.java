package com.cilazatta.vollMed.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cilazatta.vollMed.enums.HorariosDeConsultas;

public record AgendamentoDeConsultaDTO(Long idPaciente, String nomePaciente,
		Long idMedico, String NomeMedico, LocalDateTime dataDoAgendamento, LocalDate dataDaConsuslta, HorariosDeConsultas horario ) {

}
