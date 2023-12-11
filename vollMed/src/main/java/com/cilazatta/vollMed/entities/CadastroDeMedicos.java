package com.cilazatta.vollMed.entities;

import org.hibernate.validator.constraints.Length;

import com.cilazatta.vollMed.dto.CadastroDeMedicosAtualizaDTO;
import com.cilazatta.vollMed.enums.Especialidade;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cadastrodemedico")
public class CadastroDeMedicos {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	@NotBlank(message = "Preenchimento Obrigatorio")
	@Length(min = 5, max = 50)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50)
	@NotBlank(message = "Preenchimento Obrigatorio")
	@Email(message = "Deve ser um E-mail valido")
	private String email;
	
	@Column(name = "telefone", nullable = false, length = 16)
	@Length(max = 16)
	@NotBlank(message = "Preenchimento Obrigatorio")
	private String telefone;
	
	@Column(name = "crm", nullable = false, length = 14, unique = true)
	@NotBlank(message = "Preenchimento Obrigatorio")
	private String crm;

	@Enumerated(EnumType.STRING)
	@Column(name = "especialidade")
	private Especialidade especialidade;

	@Embedded
	private Endereco endereco;
	
	@Column(name = "inativo")	
	@Setter(value = AccessLevel.NONE) private Boolean isInativo = false;

	public void softDelete() {
		this.isInativo = true;
	}
	
	public void atualizarInformacoes(CadastroDeMedicosAtualizaDTO dto) {
		
		if(dto.nome() != null) {
			this.setNome(dto.nome());
		}

		if(dto.telefone()!=null) {
			this.setTelefone(dto.telefone());
		}

		if(dto.enderecoDto()!=null) {
			this.endereco.atualizaEndereco(dto.enderecoDto());
		}
	}		

}

