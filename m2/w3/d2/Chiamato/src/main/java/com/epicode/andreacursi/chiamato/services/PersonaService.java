package com.epicode.andreacursi.chiamato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.chiamato.entities.Persona;
import com.epicode.andreacursi.chiamato.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository peRep;
	
	public void inserisci(Persona p) {
		peRep.save(p);
	}
	
	public List<Persona> ottieniTutti(){
		return peRep.findAll();
	}
	
}
