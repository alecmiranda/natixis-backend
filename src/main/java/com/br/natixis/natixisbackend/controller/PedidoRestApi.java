package com.br.natixis.natixisbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.natixis.natixisbackend.model.Pedido;
import com.br.natixis.natixisbackend.repository.PedidoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PedidoRestApi {

	@Autowired
	PedidoRepository repository;
	
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos() {
		System.out.println("Buscando todos os Pedidos...");

		List<Pedido> produtos = new ArrayList<>();
		repository.findAll().forEach(produtos::add);

		return produtos;
	}
	
	@GetMapping("/pedidos/buscar/{id}")
	public Optional<Pedido> buscaPedidoporId(@PathVariable("id") String id) {
		
		System.out.println("Buscando detalhes do pedido " + id);

		return repository.findById(id);

	}

	@PostMapping("/pedidos/inserir")
	public Pedido postPedido(@RequestBody Pedido pedido) {

		System.out.println("Inserindo pedido");

		Pedido _pedido = repository.save(pedido);
		return _pedido;

	}

}
