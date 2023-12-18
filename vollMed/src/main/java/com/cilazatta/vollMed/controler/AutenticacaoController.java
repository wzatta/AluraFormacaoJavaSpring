package com.cilazatta.vollMed.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cilazatta.vollMed.dto.DadosAutenticacao;
import com.cilazatta.vollMed.dto.ResponseTokenDTO;
import com.cilazatta.vollMed.entities.Usuario;
import com.cilazatta.vollMed.security.TokenLocalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private  TokenLocalService tokenLocalService;
		
	@PostMapping
	public ResponseEntity efeturarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.userName(), dados.senha());
		var authentication = this.manager.authenticate(token);
		var tokenJwt = tokenLocalService.gerartoken((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok(new ResponseTokenDTO(tokenJwt));
	}

}
