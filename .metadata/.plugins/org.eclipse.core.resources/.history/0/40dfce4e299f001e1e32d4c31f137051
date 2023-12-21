package com.cilazatta.vollMed.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.ResponseAgendaDoMedicoDTO;
import com.cilazatta.vollMed.dto.mapper.AgendamentoDeConsultasMapper;
import com.cilazatta.vollMed.entities.AgendamentoDeConsultas;
import com.cilazatta.vollMed.entities.CadastroDeMedicos;
import com.cilazatta.vollMed.entities.CadastroDePaciente;
import com.cilazatta.vollMed.enums.HorariosDeConsultas;
import com.cilazatta.vollMed.repository.AgendamentoDeConsultaRepository;
import com.cilazatta.vollMed.repository.CadastroDeMedicosRepository;
import com.cilazatta.vollMed.repository.CadastroDePacienteRepository;

@Service
public class AgendamentoDeConsultaService {

	private final CadastroDePacienteRepository pacienteRepo;
	private final CadastroDeMedicosRepository medicoRepo;
	private final AgendamentoDeConsultaRepository agendaRepo;
	private final AgendamentoDeConsultasMapper mapper;

	public AgendamentoDeConsultaService(CadastroDePacienteRepository pacienteRepo,
			CadastroDeMedicosRepository medicoRepo, AgendamentoDeConsultaRepository agendaRepo,
			AgendamentoDeConsultasMapper mapper) {
		this.agendaRepo = agendaRepo;
		this.medicoRepo = medicoRepo;
		this.pacienteRepo = pacienteRepo;
		this.mapper = mapper;
	}

	public Boolean validarConsulta(AgendamentoDeConsultaDTO dto) {
	
		if (this.verificarHorarioDeAtendimento()) {
			if (dto.dataDaConsuslta().isEqual(LocalDate.now())) {
				if (this.verificarHorarioDisponivel(dto.horario())) {
					return this.agendarConsulta(dto);
				} else {
					return false;
				}

			} else {
				if (dto.dataDaConsuslta().isAfter(LocalDate.now())) {
					return this.agendarConsulta(dto);
				}
				return false;
			}

		} else {
			return false;
		}
	}

	private Boolean agendarConsulta(AgendamentoDeConsultaDTO dto) {
		AgendamentoDeConsultas agenda = new AgendamentoDeConsultas();
		CadastroDePaciente paciente = this.pacienteRepo.findById(dto.idPaciente()).get();
		CadastroDeMedicos medico = this.medicoRepo.findById(dto.idMedico()).get();
		agenda.setPaciente(paciente);
		agenda.setMedico(medico);
		agenda.setDataDoAgendamento(dto.dataDoAgendamento());
		agenda.setDataAgendada(dto.dataDaConsuslta());
		agenda.setHoraAgendada(dto.horario());
		try {
			this.agendaRepo.save(agenda);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//=================================	

	public List<ResponseAgendaDoMedicoDTO> findByMedico(Long id) {
		CadastroDeMedicos medico = this.medicoRepo.findById(id).get();
		List<ResponseAgendaDoMedicoDTO> meusCompromissos = this.agendaRepo.findBymedico(medico).stream()
				.map(r -> this.mapper.toAgendaDTO(r)).collect(Collectors.toList());
		return meusCompromissos;
	}

	public List<ResponseAgendaDoMedicoDTO> findByMedicoAndData(Long id) {
		CadastroDeMedicos medico = this.medicoRepo.findById(id).get();
		List<ResponseAgendaDoMedicoDTO> meusCompromissos = this.agendaRepo
				.findBymedicoAnddataagendada(medico, LocalDate.now()).stream().map(r -> this.mapper.toAgendaDTO(r))
				.collect(Collectors.toList());
		return meusCompromissos;
	}

	public Boolean verificarHorarioDisponivel(HorariosDeConsultas horaEnum) {
		DateTimeFormatter horarioEnum = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime horario = LocalTime.parse(horaEnum.getHorario(), horarioEnum);
		System.out.println("O Horario do enum é " + horario);
		if (horario.isAfter(LocalTime.now())) {
			int difHorario = horario.getHour() - LocalTime.now().getHour();
			if (difHorario >= 1) {
				return true;
			}
		}
		return false;
	}
	
//===========================================================================
	private boolean verificarHorarioDeAtendimento() {
		if (LocalDateTime.now(ZoneId.systemDefault()).getDayOfWeek() != DayOfWeek.SUNDAY) {
			
			if (LocalDateTime.now(ZoneId.systemDefault()).getHour() >= 7 && LocalDateTime.now(ZoneId.systemDefault()).getHour() < 23) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
