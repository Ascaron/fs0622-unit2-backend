package com.epicode.andreacursi.gestionedispositivi.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicode.andreacursi.gestionedispositivi.entities.Utente;
import com.epicode.andreacursi.gestionedispositivi.services.UtenteService;

@Controller
public class UtenteController {

	@Autowired
	private UtenteService uteSe;
	
	//PRENDI TUTTI GLI UTENTI
	@GetMapping("utenti")
	@ResponseBody
	public ResponseEntity<List<Utente>> ottieniTutti() {
		List<Utente> utenti = uteSe.ottieniTutti();
		
		if( utenti.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(utenti, HttpStatus.OK);
	}
	
	//PRENDI UN UTENTE DA ID
	@GetMapping("utenti/{id}")
	@ResponseBody
	public ResponseEntity<Object> ottieniDaId(@PathVariable Integer id) {
		Optional<Utente> utenteObj = uteSe.ottieniDaId(id);
		ResponseEntity<Object> check = checkExists(utenteObj);
		if( check != null ) return check;
		
		return new ResponseEntity<>(utenteObj.get(), HttpStatus.OK);
	}
	
	//PRENDI UN UTENTE DA USERNAME
	@GetMapping("utentiusername/{username}")
	@ResponseBody
	public ResponseEntity<List<Utente>> ottieniDaUsername(@PathVariable String username) {
		List<Utente> utenti = uteSe.ottieniDaUsername(username);
		
		if( utenti.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(utenti, HttpStatus.OK);
	}
	
	//AGGIUNGI UN UTENTE
	@PostMapping("utenti")
	@ResponseBody
	public ResponseEntity<Object> create(@RequestBody Utente u) {
		Utente utente = uteSe.inserisci(u);
		
		return new ResponseEntity<>(utente, HttpStatus.CREATED);
	}
	
	//MODIFICA UN UTENTE
	@PutMapping("utenti/{id}")
	@ResponseBody
	public ResponseEntity<Object> update(
			@PathVariable Integer id,
			@RequestBody Utente _utente) {
		
		Optional<Utente> utenteObj = uteSe.ottieniDaId(id);
		
		ResponseEntity<Object> check = checkExists(utenteObj);
		if( check != null ) return check;
		
		Utente utente = utenteObj.get();
		utente.setUsername(_utente.getUsername());
		utente.setNome(_utente.getNome());
		utente.setCognome(_utente.getCognome());
		utente.setEmail(_utente.getEmail());
		utente.setPassword(_utente.getPassword());
		utente.setRuolo(_utente.getRuolo());
		uteSe.inserisci(utente);
		
		return new ResponseEntity<>(utente, HttpStatus.CREATED);
	}
	
	//METODO DI CHECK
	private ResponseEntity<Object> checkExists(Optional<Utente> obj) {
		if( !obj.isPresent() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return null;
	}
	
	//CANCELLA UN UTENTE	
	@DeleteMapping("utenti/{id}")
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Optional<Utente> utenteObj = uteSe.ottieniDaId(id);
		ResponseEntity<Object> check = checkExists(utenteObj);
		if( check != null ) return check;
		
		uteSe.cancella(utenteObj.get());
		return new ResponseEntity<>(
				String.format("Utente con id %d cancellato!", id), HttpStatus.OK);
	}
	
}
