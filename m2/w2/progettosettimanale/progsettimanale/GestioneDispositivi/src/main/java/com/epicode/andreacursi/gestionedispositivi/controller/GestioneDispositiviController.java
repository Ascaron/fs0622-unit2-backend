package com.epicode.andreacursi.gestionedispositivi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GestioneDispositiviController {

	@GetMapping("/")
	@ResponseBody
	private String home() {
		return "HOMEPAGE";
	}
	
	@GetMapping("/saluto")
	@ResponseBody
	private String saluto() {
		return "Salve, benvenuto";
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	private String loginSuccesso() {
		return "LOGIN ANDATO A BUON FINE";
	}
	
	@GetMapping("/pagina1")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	private String pagUno() {
		return "PAGINA 1";
	}
	
}
