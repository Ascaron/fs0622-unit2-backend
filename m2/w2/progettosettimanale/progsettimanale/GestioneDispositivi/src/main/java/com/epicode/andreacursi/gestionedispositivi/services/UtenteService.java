package com.epicode.andreacursi.gestionedispositivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestionedispositivi.entities.Utente;
import com.epicode.andreacursi.gestionedispositivi.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository uteRepo;
	
	public Utente inserisci(Utente u) {
		return uteRepo.save(u);
	}
	
	public Optional<Utente> ottieniDaId(int id){
		return uteRepo.findById(id);
	}
	
	public List<Utente> ottieniTutti(){
		return uteRepo.findAll();
	}
	
	public List<Utente> ottieniDaUsername(String username){
		return uteRepo.findByUsername(username);
	}
	
	public void cancella(Utente u) {
		uteRepo.delete(u);
	}
	
}
