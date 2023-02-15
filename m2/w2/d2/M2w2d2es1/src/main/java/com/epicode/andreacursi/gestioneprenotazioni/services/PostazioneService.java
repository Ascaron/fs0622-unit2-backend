package com.epicode.andreacursi.gestioneprenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Postazione;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository posRepo;
	
	public void inserisciPos(Postazione p) {
		posRepo.save(p);
	}
	
}
