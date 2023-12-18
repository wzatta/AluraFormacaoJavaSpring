package com.cilazatta.vollMed.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cilazatta.vollMed.dto.ResponseUsuarioDTO;
import com.cilazatta.vollMed.dto.UsuarioDTO;
import com.cilazatta.vollMed.dto.mapper.UsuarioMapper;
import com.cilazatta.vollMed.entities.Usuario;
import com.cilazatta.vollMed.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repo;
	private final UsuarioMapper mapper;
	private final PasswordEncoder encoder;
	
	public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper, PasswordEncoder encoder) {
		this.repo = repo;
		this.mapper = mapper;
		this.encoder = encoder;}
	
	public ResponseUsuarioDTO cadastrar(UsuarioDTO dto) {
		Usuario usuario = this.mapper.toOBJ(dto);
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario = this.repo.save(usuario);
		return this.mapper.toDTO(usuario);
	}
	
	public ResponseUsuarioDTO findById(Long id) {
		Usuario usuario = repo.findById(id).orElseThrow();
		return this.mapper.toDTO(usuario);
	}
	
	public List<ResponseUsuarioDTO> findAll() {
		return this.repo.findAll().stream()
				.map(mapper::toDTO)
				.collect(Collectors.toList());
	}
	
}
