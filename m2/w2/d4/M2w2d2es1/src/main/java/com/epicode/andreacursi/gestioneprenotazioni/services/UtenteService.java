package com.epicode.andreacursi.gestioneprenotazioni.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utRepo;
	
	public void inserisciUte(Utente u) {
		utRepo.save(u);	
	}
	
	public Optional<Utente> ottieniUtenteDaId(int id) {
		return utRepo.findById(id);
	}
	
}
