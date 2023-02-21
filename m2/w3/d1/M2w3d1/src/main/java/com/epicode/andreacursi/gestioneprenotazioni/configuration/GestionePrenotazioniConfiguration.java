package com.epicode.andreacursi.gestioneprenotazioni.configuration;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.models.TipoDiRuolo;

@Configuration
public class GestionePrenotazioniConfiguration {

	//EDIFICI
	
	@Bean
	public Edificio ed1() {
		Edificio e= Edificio.builder().nome("Palazzo1").indirizzo("Via Roma 1").citta("Firenze").valoreCriptato("1a2b3c4d")
				.build();
		return e;
	}
	
	
	@Bean
	public Edificio ed2() {
		Edificio e= Edificio.builder().nome("Palazzo2").indirizzo("Via Milano 2").citta("Roma").valoreCriptato("1a2b3c4d")
				.build();
		return e;
	}
	
	@Bean
	public Edificio ed3() {
		Edificio e= Edificio.builder().nome("Palazzo3").indirizzo("Via Genova 5").citta("Napoli").valoreCriptato("1a2b3c4d")
				.build();
		return e;
	}
	
	@Bean
	public Edificio ed4() {
		Edificio e= Edificio.builder().nome("Palazzo4").indirizzo("Via Londra 8").citta("Milano").valoreCriptato("1a2b3c4d")
				.build();
		return e;
	}
	
	//RUOLI
	
	@Bean
	public Ruolo ru1() {
		Ruolo ru=Ruolo.builder().tipo(TipoDiRuolo.RUOLO_ADMIN).build();
		return ru;
	}
	
	@Bean
	public Ruolo ru2() {
		Ruolo ru=Ruolo.builder().tipo(TipoDiRuolo.RUOLO_USER).build();
		return ru;
	}
	
	//UTENTI
	
	@Bean
	public Utente ut1() {
		Utente u=Utente.builder().username("mario").nomeCompleto("Mario Rossi")
				.email("mario@rossi.it").password("password1").ruolo(new HashSet<>() {{add(ru1())
					;add(ru2());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut2() {
		Utente u=Utente.builder().username("luigi").nomeCompleto("Luigi Verdi")
				.email("luigi@verdi.it").password("password2").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut3() {
		Utente u=Utente.builder().username("anna").nomeCompleto("Anna Neri")
				.email("anna@neri.it").password("password3").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut4() {
		Utente u=Utente.builder().username("diego").nomeCompleto("Diego Bianchi")
				.email("diego@bianchi.it").password("password4").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
}
