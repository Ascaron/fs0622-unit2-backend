package com.epicode.andreacursi.gestioneprenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.andreacursi.gestioneprenotazioni.model.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.repositories.EdificioRepository;

@Service
public class EdificioService {
	
	@Autowired
	private EdificioRepository ediRepo;

	public Edificio inserisci(Edificio e) {
		return ediRepo.save(e);

	}
	
	public void cancella(Edificio e) {
		ediRepo.delete(e);
	}
	
	public List<Edificio> ottieniTutti() {
		return ediRepo.findAll();
	}
	
	public Optional<Edificio> ottieniDaId(int id) {
		return ediRepo.findById(id);
	}
	
	public List<Edificio> ottieniDaNome(String nome) {
		return ediRepo.findByNome(nome);
	}
	
	public Page<Edificio> ottieniTuttePag(Pageable pageable) {
		return ediRepo.findAll(pageable);
	}
}
