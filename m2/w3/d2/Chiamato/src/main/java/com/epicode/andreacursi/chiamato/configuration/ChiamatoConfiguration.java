package com.epicode.andreacursi.chiamato.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.chiamato.entities.Persona;

@Configuration
public class ChiamatoConfiguration {
	
	@Bean
	public Persona p1() {
		Persona p=Persona.builder().nome("Mario").cognome("Rossi").build();
		return p;
	}
	
	@Bean
	public Persona p2() {
		Persona p=Persona.builder().nome("Luigi").cognome("Verdi").build();
		return p;
	}
	
	@Bean
	public Persona p3() {
		Persona p=Persona.builder().nome("Anna").cognome("Neri").build();
		return p;
	}
	
	@Bean
	public Persona p4() {
		Persona p=Persona.builder().nome("Diego").cognome("Bianchi").build();
		return p;
	}
	
}
