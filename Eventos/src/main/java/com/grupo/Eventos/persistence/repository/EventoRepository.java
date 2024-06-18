package com.grupo.Eventos.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grupo.Eventos.persistence.model.Evento;



public interface EventoRepository extends CrudRepository<Evento, Integer> {
	List<Evento> findAll();
}
