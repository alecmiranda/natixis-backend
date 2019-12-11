package com.br.natixis.natixisbackend.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
//@NoArgsConstructor
@Document(collection = "produto")
public class Produto {
	
	@Id
	private String id;
	private String nome;
	private BigDecimal valor;
	
	public Produto(String nome, BigDecimal valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	
}
