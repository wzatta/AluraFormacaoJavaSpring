package com.cilazatta.vollMed.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cilazatta.vollMed.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenLocalService tokenService;
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
			var tokenJWT = recuperarToken(request);
			
			if(tokenJWT != null) {
		    var subject = tokenService.getSubject(tokenJWT);
		    var usuario = repo.findByUserName(subject);
		    System.out.println(usuario.getUsername());
		    var authentication = new UsernamePasswordAuthenticationToken(usuario,null ,usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
			
			System.out.println("Requisição Capturada");
			filterChain.doFilter(request, response);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
			if(authorizationHeader != null) {
				return authorizationHeader.replace("Bearer ", "");
			}
				return null;
	}

}
