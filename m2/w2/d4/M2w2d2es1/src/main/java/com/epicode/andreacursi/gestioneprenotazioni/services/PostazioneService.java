package com.epicode.andreacursi.gestioneprenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Postazione;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository posRepo;
	
	public Postazione inserisciPos(Postazione p) {
		return posRepo.save(p);
	}
	
	public void cancella(Postazione p) {
		posRepo.delete(p);
	}
	
	public List<Postazione> ottieniTutti() {
		return posRepo.findAll();
	}
	
	public Optional<Postazione> ottieniDaId(int id) {
		return posRepo.findById(id);
	}
	
}
