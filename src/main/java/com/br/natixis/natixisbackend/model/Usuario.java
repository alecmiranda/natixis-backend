package com.br.natixis.natixisbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
//@NoArgsConstructor
@Document(collection = "usuario")
public class Usuario {
	
	@Id
	private String id;
	private String nome;
	private String email;
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	
}
