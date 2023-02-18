package com.epicode.andreacursi.gestionedispositivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestionedispositivi.entities.Dispositivo;
import com.epicode.andreacursi.gestionedispositivi.repositories.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
	private DispositivoRepository disRepo;
	
	public Dispositivo inserisci(Dispositivo d) {
		return disRepo.save(d);
	}
	
	public Optional<Dispositivo> ottieniDaId(int id){
		return disRepo.findById(id);
	}
	
	public List<Dispositivo> ottieniTutti(){
		return disRepo.findAll();
	}
	
	public List<Dispositivo> ottieniDaTipo(String tipo){
		return disRepo.findByTipo(tipo);
	}
	
	public List<Dispositivo> ottieniDaStato(String stato){
		return disRepo.findByStato(stato);
	}
	
	public void cancella(Dispositivo d) {
		disRepo.delete(d);
	}
	
}
