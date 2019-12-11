package com.br.natixis.natixisbackend.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
//@NoArgsConstructor
@Document(collection = "pedido")
public class Pedido {
	
	@Id
	private String id;
	private List<Item> itens;
	private BigDecimal valorTotal;
	

	
	
}
