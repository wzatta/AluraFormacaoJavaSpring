package com.cilazatta.vollMed.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.CadastroDePacienteAtualizaDTO;
import com.cilazatta.vollMed.dto.CadastroDePacienteDTO;
import com.cilazatta.vollMed.dto.CadastroDePacienteListaDTO;
import com.cilazatta.vollMed.entities.CadastroDePaciente;

@Component
public class CadastroDePacienteMapper {

	@Autowired
	private EnderecoMapper endMapper;
	
	public CadastroDePacienteDTO toDTO(CadastroDePaciente obj) {
		return new CadastroDePacienteDTO(obj.getId(), obj.getNome(), obj.getEmail(), obj.getTelefone(), obj.getCpf(),
				endMapper.toDTO(obj.getEndereco()));
	}
	
	public CadastroDePacienteListaDTO toListaDTO(CadastroDePaciente obj) {
		return new CadastroDePacienteListaDTO(obj.getNome(), obj.getEmail(), obj.getCpf());
	}
	
	public CadastroDePacienteAtualizaDTO toAtualizaDTO(CadastroDePaciente obj) {
		return new CadastroDePacienteAtualizaDTO(obj.getId(), obj.getNome(), obj.getTelefone(), 
				endMapper.toDTO(obj.getEndereco()));
	}

	public CadastroDePaciente toEntity(CadastroDePacienteDTO dto) {

		CadastroDePaciente paciente = new CadastroDePaciente();
		if (dto.id() != null) {
			paciente.setId(dto.id());
		}
		paciente.setNome(dto.nome());
		paciente.setEmail(dto.email());
		paciente.setTelefone(dto.telefone());
		paciente.setCpf(dto.cpf());
		paciente.setEndereco(endMapper.toObj(dto.enderecoDto()));

		return paciente;

	}

}
