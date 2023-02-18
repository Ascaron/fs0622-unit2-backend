package com.epicode.andreacursi.gestioneprenotazioni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.epicode.andreacursi.gestioneprenotazioni.model.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.services.EdificioService;

//@RestController
//@RequestMapping("/api")
@Controller
public class EdificioController {

	//EDIFICI
	
		@Autowired
		private EdificioService edoSe;
		
		@GetMapping("edifici")
		@ResponseBody
		public ResponseEntity<List<Edificio>> getAll() {
			List<Edificio> edificio = edoSe.ottieniTutti();
			
			if( edificio.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(edificio, HttpStatus.OK);
		}
		
		@GetMapping("edifici/{id}")
		@ResponseBody
		public ResponseEntity<Object> ottieniDaId(@PathVariable Integer id) {
			Optional<Edificio> edificioObj = edoSe.ottieniDaId(id);
			ResponseEntity<Object> check = checkExists(edificioObj);
			if( check != null ) return check;
			
			return new ResponseEntity<>(edificioObj.get(), HttpStatus.OK);
		}
		
		@GetMapping("edificidanome/{nome}")
		@ResponseBody
		public ResponseEntity<List<Edificio>> ottieniDaNome(@PathVariable String nome) {
			List<Edificio> edifici = edoSe.ottieniDaNome(nome);
			
			if( edifici.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(edifici, HttpStatus.OK);
		}
		
		@GetMapping("edifici/pag")
		@ResponseBody
		public ResponseEntity<Object> ottieniTuttePag(Pageable pageable) {
			Page<Edificio> edifici = edoSe.ottieniTuttePag(pageable);
			
			if( edifici.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(edifici, HttpStatus.OK);
		}
		
		@PostMapping("edifici")
		@ResponseBody
		public ResponseEntity<Object> create(@RequestBody Edificio e) {
			Edificio edificio = edoSe.inserisci(e);
			
			return new ResponseEntity<>(edificio, HttpStatus.CREATED);
		}
		
		@PutMapping("edifici/{id}")
		@ResponseBody
		public ResponseEntity<Object> update(
				@PathVariable Integer id,
				@RequestBody Edificio _edificio) {
			
			Optional<Edificio> edificioObj = edoSe.ottieniDaId(id);
			
			ResponseEntity<Object> check = checkExists(edificioObj);
			if( check != null ) return check;
			
			Edificio edificio = edificioObj.get();
			edificio.setNome( _edificio.getNome() );
			edificio.setIndirizzo(_edificio.getIndirizzo());
			edificio.setCitta(_edificio.getCitta());
			edoSe.inserisci(edificio);
			
			return new ResponseEntity<>(edificio, HttpStatus.CREATED);
		}
		
		private ResponseEntity<Object> checkExists(Optional<Edificio> obj) {
			if( !obj.isPresent() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return null;
		}
		
		@DeleteMapping("edifici/{id}")
		@ResponseBody
		public ResponseEntity<Object> delete(@PathVariable Integer id) {
			Optional<Edificio> edificioObj = edoSe.ottieniDaId(id);
			ResponseEntity<Object> check = checkExists(edificioObj);
			if( check != null ) return check;
			
			edoSe.cancella(edificioObj.get());
			return new ResponseEntity<>(
					String.format("Edificio con id %d cancellato!", id), HttpStatus.OK);
		}
	
}
