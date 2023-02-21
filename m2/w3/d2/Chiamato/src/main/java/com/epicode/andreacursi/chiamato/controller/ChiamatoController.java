package com.epicode.andreacursi.chiamato.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.andreacursi.chiamato.entities.Persona;
import com.epicode.andreacursi.chiamato.services.PersonaService;

@RestController
@RequestMapping("/chiamato")
public class ChiamatoController {
	
	@Autowired
	private PersonaService perSe;

	@GetMapping("/")
	public String index() {
		return "home page";
	}
	
	@GetMapping("/data1")
	public String data1() {
		return "DATA 1";
	}
	
	@GetMapping("/data2")
	public ResponseEntity<List<Persona>> data2() {
		List<Persona> persone = perSe.ottieniTutti();
		
		if( persone.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(persone, HttpStatus.OK);
	}
	
	@GetMapping("/data3")
	@RequestMapping(value="/data3", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> data3() {
		List<Persona> persone = perSe.ottieniTutti();
		if( persone.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(persone, HttpStatus.OK);
	}
	
	@PostMapping("/login_success")
	public String login_success() {
		return "login success";
	}
	
}
