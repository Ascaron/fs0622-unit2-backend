package com.epicode.andreacursi.gestioneprenotazioni.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository uteRepo;
	
	public void inserisci(Utente u) {
		uteRepo.save(u);	
	}
	
	public Optional<Utente> ottieniDaId(int id) {
		return uteRepo.findById(id);
	}
	
	public Optional<Utente> ottieniDaUsername(String username){
		return uteRepo.findByUsername(username);
	}
	
}
