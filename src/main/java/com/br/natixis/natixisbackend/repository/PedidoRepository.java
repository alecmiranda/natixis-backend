package com.br.natixis.natixisbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.natixis.natixisbackend.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String>{
	
}
