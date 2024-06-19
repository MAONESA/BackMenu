package com.grupo.Eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo.Eventos.persistence.model.Usuario;
import com.grupo.Eventos.persistence.repository.UsuarioRepository;

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@PostMapping("/")
	public void createUsuario(@RequestBody Usuario usuario) {
		UsuarioRepository.save(usuario);
	}
	
	@GetMapping("/")
	public List<Usuario> selectUsuario() {
		List<Usuario> usuario = UsuarioRepository.findAll();
		return usuario;
	}
	
	@PutMapping("/{id}")
	public void updateUsuario(@RequestBody Usuario usuario, @PathVariable("id")Integer id) {
		usuario.setId(id);
		UsuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable("id") Integer id) {
		Usuario i = new Usuario();
		i.setId(id);
		UsuarioRepository.delete(i);
	}

}
