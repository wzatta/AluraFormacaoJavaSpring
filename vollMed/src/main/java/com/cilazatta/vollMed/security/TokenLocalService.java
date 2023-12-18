package com.cilazatta.vollMed.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cilazatta.vollMed.entities.Usuario;

@Service
public class TokenLocalService {
	
	
	private String secret="12345678";
	
	public String gerartoken(Usuario usuario) {
		try {
		    Algorithm algoritimo = Algorithm.HMAC256(secret);
		    String token = JWT.create()
		        .withIssuer("API VOLL.MED")
		        .withSubject(usuario.getUsername())
		        .withClaim("nome", usuario.getNome())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritimo);
		    return token;
		} catch (JWTCreationException exception){
			throw new RuntimeException("Erro ao Gerar o Token JWT", exception);
		}
		
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public String getSubject(String tokenJWT) {
		try {
		    Algorithm algoritimo = Algorithm.HMAC256(secret);
		    return JWT.require(algoritimo)
		        .withIssuer("API VOLL.MED")
		        .build()
		        .verify(tokenJWT)
		        .getSubject();
		        
		} catch (JWTVerificationException exception){
		    throw new RuntimeException("Token JWT invalido ou Expirado!");
		}
		
	}

}
