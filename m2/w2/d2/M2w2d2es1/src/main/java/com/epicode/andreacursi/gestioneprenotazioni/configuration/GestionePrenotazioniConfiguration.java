package com.epicode.andreacursi.gestioneprenotazioni.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.gestioneprenotazioni.model.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.model.Postazione;
import com.epicode.andreacursi.gestioneprenotazioni.model.Prenotazioni;
import com.epicode.andreacursi.gestioneprenotazioni.model.TipoPostazione;
import com.epicode.andreacursi.gestioneprenotazioni.model.Utente;

@Configuration
public class GestionePrenotazioniConfiguration {

	//EDIFICI
	
		@Bean
		public Edificio ed1() {
			Edificio e= Edificio.builder().nome("Palazzo1").indirizzo("Via Roma 1").citta("Firenze").build();
			return e;
		}
		
		
		@Bean
		public Edificio ed2() {
			Edificio e= Edificio.builder().nome("Palazzo2").indirizzo("Via Milano 2").citta("Roma").build();
			return e;
		}
		
		@Bean
		public Edificio ed3() {
			Edificio e= Edificio.builder().nome("Palazzo3").indirizzo("Via Genova 5").citta("Napoli").build();
			return e;
		}
		
		@Bean
		public Edificio ed4() {
			Edificio e= Edificio.builder().nome("Palazzo4").indirizzo("Via Londra 8").citta("Milano").build();
			return e;
		}
		
		//POSTAZIONI
		
		@Bean
		public Postazione po1() {
			Postazione po=Postazione.builder().codice("1a2b3c").descrizione("Postazione 1")
					.tipo(TipoPostazione.PRIVATO).maxOccupanti(1).edificio(ed1()).build();
			return po;
		}
		
		@Bean
		public Postazione po2() {
			Postazione po=Postazione.builder().codice("2a3b4c").descrizione("Postazione 2")
					.tipo(TipoPostazione.OPENSPACE).maxOccupanti(20).edificio(ed1()).build();
			return po;
		}
		
		@Bean
		public Postazione po3() {
			Postazione po=Postazione.builder().codice("1x2y3z").descrizione("Postazione 3")
					.tipo(TipoPostazione.SALARIUNIONI).maxOccupanti(5).edificio(ed2()).build();
			return po;
		}
		
		@Bean
		public Postazione po4() {
			Postazione po=Postazione.builder().codice("2x3y4z").descrizione("Postazione 4")
					.tipo(TipoPostazione.PRIVATO).maxOccupanti(1).edificio(ed3()).build();
			return po;
		}
		
		@Bean
		public Postazione po5() {
			Postazione po=Postazione.builder().codice("4d5e6f").descrizione("Postazione 5")
					.tipo(TipoPostazione.SALARIUNIONI).maxOccupanti(5).edificio(ed4()).build();
			return po;
		}
		
		//UTENTI
		
		@Bean
		public Utente ut1() {
			Utente u=Utente.builder().username("mario").nomeCompleto("Mario Rossi")
					.email("mario@rossi.it").build();
			return u;
		}
		
		@Bean
		public Utente ut2() {
			Utente u=Utente.builder().username("luigi").nomeCompleto("Luigi Verdi")
					.email("luigi@verdi.it").build();
			return u;
		}
		
		@Bean
		public Utente ut3() {
			Utente u=Utente.builder().username("anna").nomeCompleto("Anna Neri")
					.email("anna@neri.it").build();
			return u;
		}
		
		@Bean
		public Utente ut4() {
			Utente u=Utente.builder().username("diego").nomeCompleto("Diego Bianchi")
					.email("diego@bianchi.it").build();
			return u;
		}
		
		
		//PRENOTAZIONI
		
		@Bean
		public Prenotazioni pr1() {
			Prenotazioni pr=Prenotazioni.builder().dataPrenotazione(LocalDate.of(2023, 5, 5))
					.utentePrenotato(ut1()).postazionePrenotata(po1()).build();
			return pr;

		}
		
		@Bean
		public Prenotazioni pr2() {
			Prenotazioni pr=Prenotazioni.builder().dataPrenotazione(LocalDate.of(2023, 2, 2))
					.utentePrenotato(ut2()).postazionePrenotata(po2()).build();
			return pr;

		}
		
		@Bean
		public Prenotazioni pr3() {
			Prenotazioni pr=Prenotazioni.builder().dataPrenotazione(LocalDate.of(2023, 7, 7))
					.utentePrenotato(ut3()).postazionePrenotata(po3()).build();
			return pr;

		}
	
}
