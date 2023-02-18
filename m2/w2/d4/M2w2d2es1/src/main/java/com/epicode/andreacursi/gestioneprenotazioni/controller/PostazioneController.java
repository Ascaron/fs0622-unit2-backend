package com.epicode.andreacursi.gestioneprenotazioni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.gestioneprenotazioni.model.Postazione;
import com.epicode.andreacursi.gestioneprenotazioni.services.EdificioService;
import com.epicode.andreacursi.gestioneprenotazioni.services.PostazioneService;

//@RestController
//@RequestMapping("/api")
@Controller
public class PostazioneController {

	//POSTAZIONI
	
	@Autowired
	private PostazioneService posSe;
	
	@Autowired
	private EdificioService edoSe;
	
	@GetMapping("postazioni")
	@ResponseBody
	public ResponseEntity<List<Postazione>> getAll() {
		List<Postazione> postazione = posSe.ottieniTutti();
		
		if( postazione.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(postazione, HttpStatus.OK);
	}
	
	@GetMapping("postazioni/{id}")
	@ResponseBody
	public ResponseEntity<Object> ottieniDaId(@PathVariable Integer id) {
		Optional<Postazione> postazioneObj = posSe.ottieniDaId(id);
		ResponseEntity<Object> check = checkExists(postazioneObj);
		if( check != null ) return check;
		
		return new ResponseEntity<>(postazioneObj.get(), HttpStatus.OK);
	}
	
	@PostMapping("postazioni")
	@ResponseBody
	public ResponseEntity<Object> create(@RequestBody Postazione p) {
		Postazione postazione = posSe.inserisciPos(p);
		
		return new ResponseEntity<>(postazione, HttpStatus.CREATED);
	}
	
	@PutMapping("postazioni/{id}")
	@ResponseBody
	public ResponseEntity<Object> update(
			@PathVariable Integer id,
			@RequestBody Postazione _postazione) {
		
		Optional<Postazione> postazioneObj = posSe.ottieniDaId(id);
		
		ResponseEntity<Object> check = checkExists(postazioneObj);
		if( check != null ) return check;
		
		Postazione postazione = postazioneObj.get();
		postazione.setCodice( _postazione.getCodice() );
		postazione.setDescrizione(_postazione.getDescrizione());
		postazione.setTipo(_postazione.getTipo());
		postazione.setMaxOccupanti(_postazione.getMaxOccupanti());
		postazione.setEdificio(_postazione.getEdificio());
		posSe.inserisciPos(postazione);
		
		return new ResponseEntity<>(postazione, HttpStatus.CREATED);
	}
	
	private ResponseEntity<Object> checkExists(Optional<Postazione> obj) {
		if( !obj.isPresent() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return null;
	}
	
	@DeleteMapping("postazione/{id}")
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Optional<Postazione> postazioneObj = posSe.ottieniDaId(id);
		ResponseEntity<Object> check = checkExists(postazioneObj);
		if( check != null ) return check;
		
		posSe.cancella(postazioneObj.get());
		return new ResponseEntity<>(
				String.format("Postazione con id %d cancellata!", id), HttpStatus.OK);
	}
	
}
