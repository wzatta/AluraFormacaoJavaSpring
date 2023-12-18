package com.cilazatta.vollMed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(
		@NotBlank
		@NotNull
		String userName, 
		
		@NotBlank
		@NotNull		
		String senha) {

}
