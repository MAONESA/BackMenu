package com.grupo.Eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.grupo.Eventos.persistence.model.Usuario;
import com.grupo.Eventos.persistence.repository.UsuarioRepository;


@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/user")

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/")
	public void createUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Usuario loginRequest) {
	    Usuario usuario = usuarioRepository.findByUsername(loginRequest.getUsername());
	    if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
	        return ResponseEntity.status(200).body("Login Successful");
	    } else {
	        return ResponseEntity.status(401).body("Invalid Credentials");
	    }
	}

	
	@GetMapping("/")
	public List<Usuario> selectUsuario() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario;
	}
	
	@PutMapping("/{id}")
	public void updateUsuario(@RequestBody Usuario usuario, @PathVariable("id")Integer id) {
		usuario.setId(id);
		usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable("id") Integer id) {
		Usuario i = new Usuario();
		i.setId(id);
		usuarioRepository.delete(i);
	}

}
