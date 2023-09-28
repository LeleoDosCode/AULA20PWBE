package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;

@Service
public class LigacaoService {
	@Autowired
	private final LigacaoRepository ligacaoRepository;
	
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}
	
	public Ligacao saveLigacao(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}
	
	public Ligacao getLigacaoById(Long id) {
		Optional <Ligacao> ligacao = ligacaoRepository.findById(id);
		return ligacao.orElse(null);
	}
	
	public List<Ligacao> getAllLigacao(){
		return ligacaoRepository.findAll();
	}
	
	public Ligacao alterLigacao(Long id, Ligacao alterarLig) {
	    Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
	    if (existeLigacao.isPresent()) {
	        alterarLig.setId(id);
	        return ligacaoRepository.save(alterarLig);
	    }
	    return null;
	}

	public boolean deleteLigacao(Long id) {
	    Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
	    if (existeLigacao.isPresent()) {
	        ligacaoRepository.deleteById(id);
	        return true;
	    }
	    return false;
	}
}
