package com.andreacursi.gestioneprenotazioni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.gestioneprenotazioni.entity.Edificio;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository ediRepo;

	public void inserisci(Edificio e) {
		ediRepo.save(e);

	}

}
