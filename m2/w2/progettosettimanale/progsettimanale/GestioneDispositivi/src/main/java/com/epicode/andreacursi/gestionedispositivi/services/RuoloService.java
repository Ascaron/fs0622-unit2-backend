package com.epicode.andreacursi.gestionedispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestionedispositivi.entities.Ruolo;
import com.epicode.andreacursi.gestionedispositivi.repositories.RuoloRepository;

@Service
public class RuoloService {

	@Autowired
	private RuoloRepository ruoRepo;
	
	public Ruolo inserisci(Ruolo r) {
		return ruoRepo.save(r);
	}
	
}
