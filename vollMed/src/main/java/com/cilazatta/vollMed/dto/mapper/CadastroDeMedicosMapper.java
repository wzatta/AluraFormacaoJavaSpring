package com.cilazatta.vollMed.dto.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.CadastroDeMedicosAtualizaDTO;
import com.cilazatta.vollMed.dto.CadastroDeMedicosDTO;
import com.cilazatta.vollMed.dto.CadastroDeMedicosListaDTO;
import com.cilazatta.vollMed.entities.CadastroDeMedicos;

@Component
public class CadastroDeMedicosMapper {
	
	@Autowired
	private EnderecoMapper endMapper;

	public CadastroDeMedicosDTO toDTO(CadastroDeMedicos medicos) {
		return new CadastroDeMedicosDTO(medicos.getId(), medicos.getNome(), medicos.getEmail(), medicos.getTelefone(),
				medicos.getCrm(), medicos.getEspecialidade(), endMapper.toDTO(medicos.getEndereco()));
	}
	
	public CadastroDeMedicosListaDTO toListaDTO(CadastroDeMedicos medicos) {
		return new CadastroDeMedicosListaDTO(medicos.getId(), medicos.getNome(), medicos.getEmail(), medicos.getCrm(), medicos.getEspecialidade());
	}
	
	public CadastroDeMedicosAtualizaDTO toAtualizaDTO(CadastroDeMedicos medicos) {
		return new CadastroDeMedicosAtualizaDTO(medicos.getId(), medicos.getNome(), medicos.getTelefone(), endMapper.toDTO(medicos.getEndereco()));
	}
	

	public CadastroDeMedicos toObj(CadastroDeMedicosDTO dto) {
		CadastroDeMedicos cadMedico = new CadastroDeMedicos();
		if (dto.id() != null) {
			cadMedico.setId(dto.id());
		}

		cadMedico.setNome(dto.nome());
		cadMedico.setEmail(dto.email());
		cadMedico.setTelefone(dto.telefone());
		cadMedico.setCrm(dto.crm());
		cadMedico.setEspecialidade(dto.especialidade());
		cadMedico.setEndereco(endMapper.toObj(dto.endereco()));

		return cadMedico;
	}

}
