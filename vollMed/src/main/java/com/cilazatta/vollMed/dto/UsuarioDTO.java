package com.cilazatta.vollMed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
		
		Long id,
		
		@NotBlank
		@NotNull
		String nome,
		
		@NotBlank
		@NotNull
		String userName,
		
		@NotBlank
		@NotNull
		String senha) {
}
