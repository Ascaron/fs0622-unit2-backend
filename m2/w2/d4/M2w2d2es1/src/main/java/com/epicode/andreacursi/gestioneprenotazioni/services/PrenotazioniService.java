package com.epicode.andreacursi.gestioneprenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Prenotazioni;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.PrenotazioniRepository;

@Service
public class PrenotazioniService {
	
	@Autowired
	private PrenotazioniRepository preRepo;
	
	public void inserisciPre(Prenotazioni pr) {
		preRepo.save(pr);
	}
	
}
