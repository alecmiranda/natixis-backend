package com.br.natixis.natixisbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.natixis.natixisbackend.model.Produto;
import com.br.natixis.natixisbackend.repository.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProdutoRestApi {

	@Autowired
	ProdutoRepository repository;

	@GetMapping("/produtos")
	public List<Produto> getProdutos() {
		System.out.println("Buscando todos os produtos...");

		List<Produto> produtos = new ArrayList<>();
		repository.findAll().forEach(produtos::add);

		return produtos;
	}
	
	@GetMapping("/produtos/buscar/{id}")
	public Optional<Produto> buscaProdutoporId(@PathVariable("id") String id) {
		
		System.out.println("Buscando detalhes do produto " + id);

		return repository.findById(id);

	}

	@PostMapping("/produtos/inserir")
	public Produto postProduto(@RequestBody Produto produto) {

		System.out.println("Inserindo produto");

		Produto _produto = repository.save(new Produto(produto.getNome(),produto.getValor()));
		return _produto;
	}

	@DeleteMapping("/produtos/deletar/{id}")
	public ResponseEntity<String> deletarProduto(@PathVariable("id") String id) {
		
		System.out.println("Deletar produto ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Produto deletado", HttpStatus.OK);
	}

	@DeleteMapping("/produtos/deletarTodos")
	public ResponseEntity<String> deletarProdutos() {
		System.out.println("Deletando todos os produtos...");

		repository.deleteAll();

		return new ResponseEntity<>("Todos os produtos foram deletados!", HttpStatus.OK);
	}

	@PutMapping("/produtos/alterar/{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable("id") String id, @RequestBody Produto produto) {
		System.out.println("alterando produto ID = " + id + "...");

		Optional<Produto> produtoDados = repository.findById(id);

		if (produtoDados.isPresent()) {
			Produto _produto = produtoDados.get();
			_produto.setNome(produto.getNome());
			_produto.setValor(produto.getValor());
			return new ResponseEntity<>(repository.save(_produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
