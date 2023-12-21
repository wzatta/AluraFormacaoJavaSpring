package com.cilazatta.vollMed.services.validadores;

import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseConsultaDTO;
import com.cilazatta.vollMed.entities.interfaces.ValidadorAgendamentoDeConsulta;
import com.cilazatta.vollMed.repository.CadastroDeMedicosRepository;
import com.cilazatta.vollMed.repository.CadastroDePacienteRepository;

@Component
public class ConsultaValidarPacienteEMedicoEstaoAtivo implements ValidadorAgendamentoDeConsulta{

	private final CadastroDePacienteRepository pacienteRepo;
	private final CadastroDeMedicosRepository medicoRepo;

	public ConsultaValidarPacienteEMedicoEstaoAtivo(CadastroDePacienteRepository pacienteRepo, 
			CadastroDeMedicosRepository medicoRepo) {
		this.medicoRepo = medicoRepo;
		this.pacienteRepo = pacienteRepo;
	}
	
	@Override
	public ResponseConsultaDTO validar(AgendamentoDeConsultaDTO dto) {

		if (!this.medicoRepo.findById(dto.idMedico()).filter(medico -> medico.getIsInativo() == false).isPresent()) {
			return new ResponseConsultaDTO(false, "Medico Não Cadastrado", null);
		}

		if (!this.pacienteRepo.findById(dto.idPaciente()).filter(paciente -> paciente.getIsInativo() == false)
				.isPresent()) {
			return new ResponseConsultaDTO(false, "Paciente Não Cadastrado", null);
		}
		
		return new ResponseConsultaDTO(true, "", null);
	
	}

}
