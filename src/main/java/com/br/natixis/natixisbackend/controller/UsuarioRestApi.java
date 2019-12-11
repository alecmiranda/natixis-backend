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

import com.br.natixis.natixisbackend.model.Usuario;
import com.br.natixis.natixisbackend.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioRestApi {

	@Autowired
	UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		System.out.println("Buscando todos os usuarios..."); 

		List<Usuario> usuarios = new ArrayList<>();
		repository.findAll().forEach(usuarios::add);

		return usuarios;
	}
	
	@PostMapping("/usuarios/autenticar")
	public Optional<Usuario> autenticarUsuario(@RequestBody Usuario usuario) {
		System.out.println("Autenticando Usuario " + usuario.getId() );
		
		return repository.findById(usuario.getId());
	}

	@PutMapping("/usuarios/inserir")
	public ResponseEntity<Boolean> postUsuario(@RequestBody Usuario usuario) {
		System.out.println("Inserindo usuario " + usuario.getNome());
		
		Optional<Usuario> _usuario = repository.findByEmail(usuario.getEmail());
		
		if(!_usuario.isPresent()) {
			repository.save(usuario);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@DeleteMapping("/usuarios/deletar/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable("id") String id) {
		
		System.out.println("Deletetando usuario com ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Usuario foi deletado!", HttpStatus.OK);
	}

	@DeleteMapping("/usuarios/deletarTodos")
	public ResponseEntity<String> deletarUsuarios() {
		System.out.println("Deletetando todos os usuarios...");

		repository.deleteAll();

		return new ResponseEntity<>("Todos usuario deletados!", HttpStatus.OK);
	}

	@PutMapping("/usuarios/alterar/{id}")
	public ResponseEntity<Usuario> alterarUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) {
		System.out.println("atualizando cliente = " + id + "...");

		Optional<Usuario> usuarioDados = repository.findById(id);

		if (usuarioDados.isPresent()) {
			Usuario _usuario = usuarioDados.get();
			_usuario.setNome(usuario.getNome());
			_usuario.setEmail(usuario.getEmail());
			return new ResponseEntity<>(repository.save(_usuario), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
