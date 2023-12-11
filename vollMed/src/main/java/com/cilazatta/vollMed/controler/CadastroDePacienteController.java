package com.cilazatta.vollMed.controler;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.vollMed.dto.CadastroDePacienteAtualizaDTO;
import com.cilazatta.vollMed.dto.CadastroDePacienteDTO;
import com.cilazatta.vollMed.dto.CadastroDePacienteListaDTO;
import com.cilazatta.vollMed.services.CadastroDePacienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/paciente")
public class CadastroDePacienteController {

	private final CadastroDePacienteService service;

	public CadastroDePacienteController(CadastroDePacienteService service) {
		this.service = service;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CadastroDePacienteDTO> cadastrar(@Valid @RequestBody CadastroDePacienteDTO dto) {
		dto = service.cadastrar(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@PutMapping
	@Transactional
	public ResponseEntity<CadastroDePacienteAtualizaDTO> atualizarPaciente(@RequestBody CadastroDePacienteAtualizaDTO dto){
		dto = service.atualizarPaciente(dto);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<List<CadastroDePacienteDTO>> findAll() {
		List<CadastroDePacienteDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/lista")
	public ResponseEntity<Page<CadastroDePacienteListaDTO>> listaPaciente(Pageable paginacao) {
		Page<CadastroDePacienteListaDTO> pagina = service.listarPaciente(paginacao);
		return ResponseEntity.ok().body(pagina);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CadastroDePacienteDTO> findById(@PathVariable @NotNull @Positive Long id) {
		CadastroDePacienteDTO dto = service.findByid(id);
		return ResponseEntity.ok().body(dto);
	}

}