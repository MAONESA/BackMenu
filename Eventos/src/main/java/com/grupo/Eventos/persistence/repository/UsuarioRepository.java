package com.grupo.Eventos.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupo.Eventos.persistence.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
		List<Usuario> findAll();
	    Usuario findByUsername(String username);
	}


