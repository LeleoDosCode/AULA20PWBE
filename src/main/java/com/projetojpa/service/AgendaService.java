package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agenda;
import com.projetojpa.repository.AgendaRepository;

@Service
public class AgendaService {
	
    private final AgendaRepository agendaRepository;

    
    @Autowired
	public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda saveAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda getAgendaById(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }

    public List<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda alterAgenda(Long id, Agenda alterarAgenda) {
        Optional<Agenda> existeAgenda = agendaRepository.findById(id);
        if (existeAgenda.isPresent()) {
            alterarAgenda.setId(id);
            return agendaRepository.save(alterarAgenda);
        }
        return null;
    }

    public boolean deleteAgenda(Long id) {
        Optional<Agenda> existeAgenda = agendaRepository.findById(id);
        if (existeAgenda.isPresent()) {
            agendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

