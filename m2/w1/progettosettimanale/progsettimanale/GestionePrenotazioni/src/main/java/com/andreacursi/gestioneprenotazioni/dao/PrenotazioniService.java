package com.andreacursi.gestioneprenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.gestioneprenotazioni.entity.Prenotazioni;

@Service
public class PrenotazioniService {

	@Autowired
	private PrenotazioniRepository preRepo;
	
	public void inserisciPre(Prenotazioni pr) {
		preRepo.save(pr);
	}
	
}
