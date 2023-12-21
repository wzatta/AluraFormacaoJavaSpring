package com.cilazatta.vollMed.entities.interfaces;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {
	
	ResponseConsultaDTO validar(AgendamentoDeConsultaDTO dto);

}
