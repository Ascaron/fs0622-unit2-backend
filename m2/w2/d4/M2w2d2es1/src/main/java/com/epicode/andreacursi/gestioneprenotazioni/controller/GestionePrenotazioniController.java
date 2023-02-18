package com.epicode.andreacursi.gestioneprenotazioni.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GestionePrenotazioniController {
	
	@GetMapping("/saluto")
	@ResponseBody
	private String saluto() {
		return "Salve, benvenuto";
	}
	
	@GetMapping("/lingua")
	@ResponseBody
	private String regole(@RequestParam("lang") String lingua) {
		if(lingua.equals("IT")) {
			String risposta= String.format("%s >Puoi prenotarti solo una volta"
					+ " al giorno, le prenotazioni valgono soltanto per quel giorno", lingua);
			return risposta;
		}
		else if(lingua.equals("EN")){
			String risposta= String.format("%s >You can only book once a day,"
					+ " reservations are valid only for that day", lingua);
			return risposta;
		}
		else {
			return "Lingua non disponibile";
		}
	}
	
	@GetMapping("/pagina1")
	@ResponseBody
	private String pag1() {
		return "PAGINA1";
	}
	
	@GetMapping("/pagina2")
	@ResponseBody
	private String pag2() {
		return "PAGINA2";
	}
	
	@GetMapping("/pagina3")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	private String pag3() {
		return "PAGINA3";
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	private String loginSuccesso() {
		return "LOGIN ANDATO A BUON FINE";
	}
	
}
