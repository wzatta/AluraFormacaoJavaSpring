package com.cilazatta.vollMed.entities;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.validator.constraints.Length;

import com.cilazatta.vollMed.dto.CadastroDePacienteAtualizaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString()
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cadastrodepaciente")
public class CadastroDePaciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	@Length(min = 5, max = 50)
	@NotBlank(message = "Preenchimento Obrigatorio")
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50)
	@Email(message = "Deve ser um E-mail valido")
	@NotBlank(message = "Preenchimento Obrigatorio")
	private String email;
	
	@Column(name = "telefone", nullable = false, length = 14)
	@NotBlank(message = "Preenchimento Obrigatorio")
	private String telefone;
	
	@Column(name="cpf", nullable = false, length = 16, unique = true)
	@NotBlank(message = "Preenchimento Obrigatorio")
	@ToStringExclude
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "inativo")	
	@ToStringExclude
	@Setter(value = AccessLevel.NONE) private Boolean isInativo = false;

	public void softDelete() {
		this.isInativo = true;
	}

	public void atualizaDados(CadastroDePacienteAtualizaDTO dto) {
		this.setNome(dto.nome());
		this.setTelefone(dto.telefone());
		this.endereco.atualizaEndereco(dto.enderecoDto());
		}
	
}
