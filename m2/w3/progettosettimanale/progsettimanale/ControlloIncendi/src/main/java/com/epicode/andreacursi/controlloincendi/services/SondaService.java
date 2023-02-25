package com.epicode.andreacursi.controlloincendi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.controlloincendi.entities.Sonda;
import com.epicode.andreacursi.controlloincendi.repositories.SondaRepository;

@Service
public class SondaService {

	@Autowired
	private SondaRepository sonRepo;
	
	public Sonda inserisci(Sonda s) {
		return sonRepo.save(s);
	}
	
	public Optional<Sonda> ottieniDaId(int id){
		return sonRepo.findById(id);
	}
	
	public List<Sonda> ottieniTutti(){
		return sonRepo.findAll();
	}
	
}
