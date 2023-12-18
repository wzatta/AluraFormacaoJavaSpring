package com.cilazatta.vollMed.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cilazatta.vollMed.dto.ResponseUsuarioDTO;
import com.cilazatta.vollMed.dto.UsuarioDTO;
import com.cilazatta.vollMed.services.UsuarioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

		private final UsuarioService service;
		
		public UsuarioController(UsuarioService service) {
			this.service = service;
		}
		
		@PostMapping
		public ResponseEntity<ResponseUsuarioDTO> cadastrar(@RequestBody @Valid UsuarioDTO dto, UriComponentsBuilder uriBuilder){
			ResponseUsuarioDTO responseDTO = service.cadastrar(dto);
			var uri = uriBuilder.path("/usuario/{id}")
					.buildAndExpand(responseDTO.id()).toUri();
			return ResponseEntity.created(uri).body(responseDTO);
		}
		
		@GetMapping
		public ResponseEntity<List<ResponseUsuarioDTO>> findAll(){
			List<ResponseUsuarioDTO> lista= this.service.findAll();
			return ResponseEntity.ok().body(lista);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<ResponseUsuarioDTO> findById(@PathVariable @Positive Long id){
			ResponseUsuarioDTO dto = this.service.findById(id);
			return ResponseEntity.ok().body(dto);
		}
		
}
