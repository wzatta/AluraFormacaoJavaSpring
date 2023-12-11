package com.cilazatta.vollMed.dto;

import com.cilazatta.vollMed.enums.Especialidade;

public record CadastroDeMedicosListaDTO(Long id, String nome, String Email, String crm, Especialidade especialidade) {

}
