package com.cilazatta.vollMed.dto.mapper;

import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseAgendaDoMedicoDTO;
import com.cilazatta.vollMed.entities.AgendamentoDeConsultas;

@Component
public class AgendamentoDeConsultasMapper {
	
	public AgendamentoDeConsultaDTO toDTO(AgendamentoDeConsultas obj) {
		return new AgendamentoDeConsultaDTO(
				obj.getPaciente().getId(),
				obj.getMedico().getId(),
				obj.getDataAgendada(),
				obj.getHoraAgendada()
				);
	}
	
	public ResponseAgendaDoMedicoDTO toAgendaDTO(AgendamentoDeConsultas obj) {
		
		return new ResponseAgendaDoMedicoDTO(
				obj.getDataAgendada().toString(),
				obj.getHoraAgendada().getHorario(),
				obj.getPaciente().getNome(),
				obj.getMedico().getNome()
				
				);
		
	}
	
	

}
