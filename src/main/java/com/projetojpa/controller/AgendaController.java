package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Agenda;
import com.projetojpa.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	

	private final AgendaService agendaService;
	
	@Autowired
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> getAgendaControlId(@PathVariable Long id){
		Agenda agenda = agendaService.getAgendaById(id);
		if (agenda != null) {
			return ResponseEntity.ok(agenda);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
		
	@GetMapping("/")
	public ResponseEntity<List<Agenda>> buscaTodosAgendaControl() {
		List<Agenda> agenda = agendaService.getAllAgenda();
		return ResponseEntity.ok(agenda);
	}
	
	@PostMapping("/")
	public ResponseEntity<Agenda> saveAgendaControl(@RequestBody Agenda agenda) {
		Agenda saveAgenda = agendaService.saveAgenda(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAgenda);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agenda> alteraAgendControl(@PathVariable Long id, @RequestBody Agenda agenda) {
		Agenda alteraAgenda = agendaService.alterAgenda(id, agenda);
		if (alteraAgenda != null) {
			return ResponseEntity.ok(agenda);
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteLigacaoControl(@PathVariable Long id) {
		boolean apagar = agendaService.deleteAgenda(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}