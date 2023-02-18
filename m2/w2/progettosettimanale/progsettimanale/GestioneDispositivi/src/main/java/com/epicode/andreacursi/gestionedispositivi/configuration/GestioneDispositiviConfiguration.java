package com.epicode.andreacursi.gestionedispositivi.configuration;

import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.gestionedispositivi.entities.Dispositivo;
import com.epicode.andreacursi.gestionedispositivi.entities.Ruolo;
import com.epicode.andreacursi.gestionedispositivi.entities.Utente;
import com.epicode.andreacursi.gestionedispositivi.model.StatoManutenzione;
import com.epicode.andreacursi.gestionedispositivi.model.TipoDiRuolo;
import com.epicode.andreacursi.gestionedispositivi.model.TipoDispositivo;

@Configuration
public class GestioneDispositiviConfiguration {
	
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
		Utente u=Utente.builder().username("mario").nome("Mario").cognome("Rossi")
				.email("mario@rossi.it").password("password1").ruolo(new HashSet<>() {{add(ru1());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut2() {
		Utente u=Utente.builder().username("luigi").nome("Luigi").cognome("Verdi")
				.email("luigi@verdi.it").password("password2").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut3() {
		Utente u=Utente.builder().username("anna").nome("Anna").cognome("Neri")
				.email("anna@neri.it").password("password3").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
	@Bean
	public Utente ut4() {
		Utente u=Utente.builder().username("diego").nome("Diego").cognome("Bianchi")
				.email("diego@bianchi.it").password("password4").ruolo(new HashSet<>() {{add(ru2());}}).build();
		return u;
	}
	
	//DISPOSITIVI
	
	@Bean
	public Dispositivo di1() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.LAPTOP).stato(StatoManutenzione.DISPONIBILE).build();
		return d;
	}
	
	@Bean
	public Dispositivo di2() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.LAPTOP).stato(StatoManutenzione.ASSEGNATO)
				.utente(ut1()).build();
		return d;
	}
	
	@Bean
	public Dispositivo di3() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.TABLET).stato(StatoManutenzione.DISPONIBILE).build();
		return d;
	}
	
	@Bean
	public Dispositivo di4() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.TABLET).stato(StatoManutenzione.DISMESSO).build();
		return d;
	}
	
	@Bean
	public Dispositivo di5() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.SMARTPHONE).stato(StatoManutenzione.ASSEGNATO)
				.utente(ut2()).build();
		return d;
	}
	
	@Bean
	public Dispositivo di6() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.SMARTPHONE).stato(StatoManutenzione.MANUTENZIONE).build();
		return d;
	}
	
	@Bean
	public Dispositivo di7() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.LAPTOP).stato(StatoManutenzione.DISPONIBILE).build();
		return d;
	}
	
	@Bean
	public Dispositivo di8() {
		Dispositivo d=Dispositivo.builder().tipo(TipoDispositivo.TABLET).stato(StatoManutenzione.ASSEGNATO)
				.utente(ut3()).build();
		return d;
	}
	
}
