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

import com.epicode.andreacursi.gestionedispositivi.entities.Dispositivo;
import com.epicode.andreacursi.gestionedispositivi.services.DispositivoService;

@Controller
public class DispositivoController {

	@Autowired
	private DispositivoService disSe;
	
	//PRENDI TUTTI I DISPOSITIVI
		@GetMapping("dispositivi")
		@ResponseBody
		public ResponseEntity<List<Dispositivo>> ottieniTutti() {
			List<Dispositivo> dispositivi = disSe.ottieniTutti();
			
			if( dispositivi.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		}
		
		//PRENDI UN DISPOSITIVO DA ID
		@GetMapping("dispositivi/{id}")
		@ResponseBody
		public ResponseEntity<Object> ottieniDaId(@PathVariable Integer id) {
			Optional<Dispositivo> dispositivoObj = disSe.ottieniDaId(id);
			ResponseEntity<Object> check = checkExists(dispositivoObj);
			if( check != null ) return check;
			
			return new ResponseEntity<>(dispositivoObj.get(), HttpStatus.OK);
		}
		
		//PRENDI DISPOSITIVI PER TIPO
		@GetMapping("dispositivitipo/{tipo}")
		@ResponseBody
		public ResponseEntity<Object> ottieniDaTipo(@PathVariable String tipo) {
			List<Dispositivo> dispositivi = disSe.ottieniDaTipo(tipo);
			if( dispositivi.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		}
		
		//PRENDI DISPOSITIVI PER STATO
		@GetMapping("dispositivistato/{stato}")
		@ResponseBody
		public ResponseEntity<Object> ottieniDaStato(@PathVariable String stato) {
			List<Dispositivo> dispositivi = disSe.ottieniDaStato(stato);
			if( dispositivi.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(dispositivi, HttpStatus.OK);
		}
		
		//AGGIUNGI UN DISPOSITIVO
		@PostMapping("dispositivi")
		@ResponseBody
		public ResponseEntity<Object> create(@RequestBody Dispositivo d) {
			Dispositivo dispositivo = disSe.inserisci(d);
			
			return new ResponseEntity<>(dispositivo, HttpStatus.CREATED);
		}
		
		//MODIFICA UN DISPOSITIVO
		@PutMapping("dispositivi/{id}")
		@ResponseBody
		public ResponseEntity<Object> update(
				@PathVariable Integer id,
				@RequestBody Dispositivo _dispositivo) {
			
			Optional<Dispositivo> dispositivoObj = disSe.ottieniDaId(id);
			
			ResponseEntity<Object> check = checkExists(dispositivoObj);
			if( check != null ) return check;
			
			Dispositivo dispositivo = dispositivoObj.get();
			dispositivo.setTipo(_dispositivo.getTipo());
			dispositivo.setStato(_dispositivo.getStato());
			dispositivo.setUtente(_dispositivo.getUtente());
			disSe.inserisci(dispositivo);
			
			return new ResponseEntity<>(dispositivo, HttpStatus.CREATED);
		}
		
		//METODO DI CHECK
		private ResponseEntity<Object> checkExists(Optional<Dispositivo> obj) {
			if( !obj.isPresent() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return null;
		}
		
		//CANCELLA UN DISPOSITIVO	
		@DeleteMapping("dispositivi/{id}")
		@ResponseBody
		public ResponseEntity<Object> delete(@PathVariable Integer id) {
			Optional<Dispositivo> dispositivoObj = disSe.ottieniDaId(id);
			ResponseEntity<Object> check = checkExists(dispositivoObj);
			if( check != null ) return check;
			
			disSe.cancella(dispositivoObj.get());
			return new ResponseEntity<>(
					String.format("Dispositivo con id %d cancellato!", id), HttpStatus.OK);
		}
	
}
