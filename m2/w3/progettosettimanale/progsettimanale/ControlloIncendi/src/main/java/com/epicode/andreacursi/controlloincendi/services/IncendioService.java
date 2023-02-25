package com.epicode.andreacursi.controlloincendi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.repositories.IncendioRepository;

@Service
public class IncendioService {

	@Autowired
	private IncendioRepository inRepo;
	
	public Incendio inserisci(Incendio i) {
		return inRepo.save(i);
	}
	
	public Optional<Incendio> ottieniDaId(int id){
		return inRepo.findById(id);
	}
	
	public List<Incendio> ottieniTutti(){
		return inRepo.findAll();
	}
	
	public List<Incendio> ottieniDaSondaId(int id){
		return inRepo.findBySondaId(id);
	}
	
	public List<Incendio> ottieniDaFumo(int fumo){
		return inRepo.findByFumo(fumo);
	}
}
