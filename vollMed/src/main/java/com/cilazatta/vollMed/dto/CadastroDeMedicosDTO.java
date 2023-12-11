package com.cilazatta.vollMed.dto;

import com.cilazatta.vollMed.enums.Especialidade;

public record CadastroDeMedicosDTO(Long id, String nome, String email, String telefone,
		String crm, Especialidade especialidade, EnderecoDTO endereco ) {
}
