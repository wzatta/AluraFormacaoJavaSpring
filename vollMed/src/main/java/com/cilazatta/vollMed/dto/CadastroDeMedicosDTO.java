package com.cilazatta.vollMed.dto;

import com.cilazatta.vollMed.enums.Especialidade;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroDeMedicosDTO(Long id, 
		@NotBlank(message = "Preenchimento Obrigatório")
		String nome, 
		
		@NotBlank(message = "Preenchimento Obrigatório")
		@Email
		String email, 
		
		@NotBlank(message = "Preenchimento Obrigatório")
		String telefone,
		
		@NotBlank(message = "Preenchimento Obrigatório")
		String crm, 
		
		@NotNull
		Especialidade especialidade, 
		
		EnderecoDTO endereco ) {
}
