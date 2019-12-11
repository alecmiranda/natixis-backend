package com.br.natixis.natixisbackend.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
//@NoArgsConstructor
@Document(collection = "item")
public class Item {
	
	@Id
	private String id;
	private Produto produto;
	private Long quantidade;
	private BigDecimal valorTotalItem;
	
	
	
	
	
}
