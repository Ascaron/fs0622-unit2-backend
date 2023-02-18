package com.epicode.andreacursi.gestioneprenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.RuoloRepository;

@Service
public class RuoloService {

	@Autowired
	private RuoloRepository ruoRepo;
	
	public Ruolo inserisci(Ruolo r) {
		return ruoRepo.save(r);
	}
	
}
