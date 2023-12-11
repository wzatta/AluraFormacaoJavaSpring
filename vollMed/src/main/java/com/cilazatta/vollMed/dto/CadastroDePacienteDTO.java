package com.cilazatta.vollMed.dto;

import com.cilazatta.vollMed.entities.Endereco;

public record CadastroDePacienteDTO(Long id, String nome, String email, String telefone, String cpf, EnderecoDTO enderecoDto ) {

}
