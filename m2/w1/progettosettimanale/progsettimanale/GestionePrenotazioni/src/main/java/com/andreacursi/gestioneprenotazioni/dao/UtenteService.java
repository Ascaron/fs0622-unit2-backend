package com.andreacursi.gestioneprenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.gestioneprenotazioni.entity.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utRepo;
	
	public void inserisciUte(Utente u) {
		utRepo.save(u);	
	}
	
}
