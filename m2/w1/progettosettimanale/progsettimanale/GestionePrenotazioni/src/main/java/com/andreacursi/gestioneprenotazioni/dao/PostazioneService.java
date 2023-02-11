package com.andreacursi.gestioneprenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.gestioneprenotazioni.entity.Postazione;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository posRepo;
	
	public void inserisciPos(Postazione p) {
		posRepo.save(p);
	}
	
}
