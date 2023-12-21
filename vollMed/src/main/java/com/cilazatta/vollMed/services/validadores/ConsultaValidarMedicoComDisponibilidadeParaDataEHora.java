package com.cilazatta.vollMed.services.validadores;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseConsultaDTO;
import com.cilazatta.vollMed.entities.CadastroDeMedicos;
import com.cilazatta.vollMed.entities.interfaces.ValidadorAgendamentoDeConsulta;
import com.cilazatta.vollMed.enums.HorariosDeConsultas;
import com.cilazatta.vollMed.exceptions.RecordNotFoundException;
import com.cilazatta.vollMed.repository.AgendamentoDeConsultaRepository;
import com.cilazatta.vollMed.repository.CadastroDeMedicosRepository;

@Component
public class ConsultaValidarMedicoComDisponibilidadeParaDataEHora implements ValidadorAgendamentoDeConsulta {

	private CadastroDeMedicos medico;

	private final AgendamentoDeConsultaRepository agendaRepo;
	private final CadastroDeMedicosRepository medicoRepo;

	public ConsultaValidarMedicoComDisponibilidadeParaDataEHora(
			CadastroDeMedicosRepository medicoRepo, 
			AgendamentoDeConsultaRepository agendaRepo) {
		this.agendaRepo = agendaRepo;
		this.medicoRepo = medicoRepo;}
	
	@Override
	public ResponseConsultaDTO validar(AgendamentoDeConsultaDTO dto) {
		
		this.medico =  this.medicoRepo.findById(dto.idMedico()).orElseThrow(()->new RecordNotFoundException(""));
		
		
		if (dto.dataDaConsulta().isAfter(LocalDate.now())) {
			if (this.verificarDisponibilidadeDeHorarioDoMedico(this.medico, dto.dataDaConsulta(), dto.horario())) {
				return new ResponseConsultaDTO(false, "Horário Indisponivel para este Medico", null);
			}
			
	}
		return new ResponseConsultaDTO(true, "", null);

}
	private Boolean verificarDisponibilidadeDeHorarioDoMedico(CadastroDeMedicos medico, LocalDate dataDaConsulta,
			HorariosDeConsultas horario) {
		return this.agendaRepo.findByMedicoAndDataAgendadaAndHoraAgendada(medico, dataDaConsulta, horario).isPresent();
	}
}