package com.cilazatta.vollMed.dto;

import com.cilazatta.vollMed.entities.Endereco;

public record CadastroDeMedicosAtualizaDTO(Long id, String nome, String telefone, EnderecoDTO enderecoDto ) {

}
