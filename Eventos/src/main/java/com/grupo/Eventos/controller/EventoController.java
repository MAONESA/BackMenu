package com.grupo.Eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.Eventos.persistence.model.Evento;
import com.grupo.Eventos.persistence.repository.EventoRepository;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/event")

public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@PostMapping("/")
	public void createEvent(@RequestBody Evento evento) {
		eventoRepository.save(evento);
	}
	
	@GetMapping
	public List<Evento> selectEvent() {
		List<Evento> evento = eventoRepository.findAll();
		return evento;
	}
	
	@PutMapping("/{id}")
	public void updateEvent(@RequestBody Evento pacient, @PathVariable("id")Integer id) {
		pacient.setId(id);
		eventoRepository.save(pacient);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable("id") Integer id) {
		Evento i = new Evento();
		i.setId(id);
		eventoRepository.delete(i);
	}
}