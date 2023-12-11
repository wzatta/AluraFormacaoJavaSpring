package com.cilazatta.vollMed.dto.mapper;

import org.springframework.stereotype.Component;

import com.cilazatta.vollMed.dto.EnderecoDTO;
import com.cilazatta.vollMed.entities.Endereco;

@Component
public class EnderecoMapper {

	public EnderecoDTO toDTO(Endereco endereco) {
		return new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero(),
				endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(),
				endereco.getCep());
	}

	public Endereco toObj(EnderecoDTO dto) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(dto.logradouro());
		endereco.setNumero(dto.numero());
		endereco.setComplemento(dto.complemento());
		endereco.setBairro(dto.bairro());
		endereco.setCidade(dto.cidade());
		endereco.setUf(dto.uf());
		endereco.setCep(dto.cep());
		return endereco;
	}
}
