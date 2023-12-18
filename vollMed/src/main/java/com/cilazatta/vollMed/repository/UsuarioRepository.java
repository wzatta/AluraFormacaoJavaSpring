package com.cilazatta.vollMed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.cilazatta.vollMed.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	UserDetails findByUserName(String username);
}
