package com.epicode.andreacursi.gestioneprenotazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.services.EdificioService;
import com.epicode.andreacursi.gestioneprenotazioni.services.UtenteService;

@Controller
public class GestionePrenotazioniController {
	
	@Autowired
	private UtenteService uteSe;
	
	@Autowired
	private EdificioService ediSe;

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "home page";
	}
	
	@GetMapping("/page1")
	@ResponseBody
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public String page1() {
		return "page 1";
	}
	
	@GetMapping("/page2")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public String page2() {
		return "page 2";
	}
	
	@GetMapping("/page3")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public String page3() {
		// ottieni inforamzioni sull'utente autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(authentication.getAuthorities());
		
		return "page 3";
	}
	
	@GetMapping("/page4")
	@ResponseBody
	@PreAuthorize("hasRole('USER')")
	public Utente page4() {
		// ottieni inforamzioni sull'utente autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Utente auth = uteSe.ottieniDaUsername(authentication.getName()).get();
		
		return auth;
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "login success";
	}
	
	@GetMapping("edifici/{id}")
	@ResponseBody
	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	public Edificio ottieniUtenteDaId(@PathVariable(name="id")Integer id) {
		return ediSe.ottieniDaId(id).get();
	}
	
//	@GetMapping("/ottieniutente/{id}")
//	@ResponseBody
//	@CrossOrigin(origins = "http://127.0.0.1:5500/")
//	public Utente getUserById(@PathVariable(name = "id") Integer id) {
//		return uteSe.ottieniDaId(id).get();
//	}
	
}
