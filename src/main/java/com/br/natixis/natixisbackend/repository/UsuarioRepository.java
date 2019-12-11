package com.br.natixis.natixisbackend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.natixis.natixisbackend.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	  public Optional<Usuario> findByEmail(String email);


}
