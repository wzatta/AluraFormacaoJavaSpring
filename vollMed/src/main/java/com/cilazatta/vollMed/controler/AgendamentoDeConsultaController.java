package com.cilazatta.vollMed.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.vollMed.dto.AgendamentoDeConsultaDTO;
import com.cilazatta.vollMed.dto.RequestByIdDTO;
import com.cilazatta.vollMed.dto.ResponseAgendaDoMedicoDTO;
import com.cilazatta.vollMed.dto.ResponseConsultaDTO;
import com.cilazatta.vollMed.services.AgendamentoDeConsultaService;

import jakarta.validation.Valid;


@RequestMapping(value = "agenda")
@RestController
public class AgendamentoDeConsultaController {
	
	@Autowired
	private AgendamentoDeConsultaService service;
	
	@PostMapping
	public ResponseEntity agendarConsulta(@RequestBody @Valid AgendamentoDeConsultaDTO dto){
		ResponseConsultaDTO registroSalvo = this.service.validarConsulta(dto);
		if(registroSalvo.status()) {
		return ResponseEntity.ok().body(registroSalvo.dto());
		} else {
			return ResponseEntity.badRequest().body(registroSalvo.texto());
		}
	}
	
	@PostMapping("/medico")
	public ResponseEntity<List<ResponseAgendaDoMedicoDTO>> findByMedico(@RequestBody RequestByIdDTO dto){
		System.out.println(dto.toString());
//		List<ResponseAgendaDoMedicoDTO> lista = this.service.findByMedico(dto.id());
		List<ResponseAgendaDoMedicoDTO> lista = this.service.findByMedicoAndData(dto.id());
		return ResponseEntity.ok().body(lista);
	}

}
