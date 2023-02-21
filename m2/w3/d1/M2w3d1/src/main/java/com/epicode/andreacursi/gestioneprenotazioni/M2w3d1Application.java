package com.epicode.andreacursi.gestioneprenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.gestioneprenotazioni.configuration.GestionePrenotazioniConfiguration;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Edificio;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.services.EdificioService;
import com.epicode.andreacursi.gestioneprenotazioni.services.RuoloService;
import com.epicode.andreacursi.gestioneprenotazioni.services.UtenteService;

@SpringBootApplication
public class M2w3d1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(M2w3d1Application.class, args);
	}
	
	@Autowired
	EdificioService ediSe;
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	RuoloService ruoSe;

	ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniConfiguration.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		inserisciEdifici();
		inserisciRuoli();
		inserisciUtenti();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public void inserisciEdifici() {
		
		Edificio ed1=(Edificio)ctx.getBean("ed1");
		ediSe.inserisci(ed1);
		
		Edificio ed2=(Edificio)ctx.getBean("ed2");
		ediSe.inserisci(ed2);
		
		Edificio ed3=(Edificio)ctx.getBean("ed3");
		ediSe.inserisci(ed3);
		
		Edificio ed4=(Edificio)ctx.getBean("ed4");
		ediSe.inserisci(ed4);
	}
	
	public void inserisciUtenti() {
		Utente ut1=(Utente)ctx.getBean("ut1");
		uteSe.inserisci(ut1);
		
		Utente ut2=(Utente)ctx.getBean("ut2");
		uteSe.inserisci(ut2);
		
		Utente ut3=(Utente)ctx.getBean("ut3");
		uteSe.inserisci(ut3);
		
		Utente ut4=(Utente)ctx.getBean("ut4");
		uteSe.inserisci(ut4);
	}
	
	public void inserisciRuoli() {
		Ruolo ru1=(Ruolo)ctx.getBean("ru1");
		ruoSe.inserisci(ru1);
		
		Ruolo ru2=(Ruolo)ctx.getBean("ru2");
		ruoSe.inserisci(ru2);
	}

}
