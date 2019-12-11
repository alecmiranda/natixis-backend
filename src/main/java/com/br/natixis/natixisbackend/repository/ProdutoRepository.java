package com.br.natixis.natixisbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.natixis.natixisbackend.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

}
