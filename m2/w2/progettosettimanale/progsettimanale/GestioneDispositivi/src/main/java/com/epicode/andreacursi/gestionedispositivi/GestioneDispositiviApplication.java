package com.epicode.andreacursi.gestionedispositivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.gestionedispositivi.configuration.GestioneDispositiviConfiguration;
import com.epicode.andreacursi.gestionedispositivi.entities.Dispositivo;
import com.epicode.andreacursi.gestionedispositivi.entities.Ruolo;
import com.epicode.andreacursi.gestionedispositivi.entities.Utente;
import com.epicode.andreacursi.gestionedispositivi.services.DispositivoService;
import com.epicode.andreacursi.gestionedispositivi.services.RuoloService;
import com.epicode.andreacursi.gestionedispositivi.services.UtenteService;

@SpringBootApplication
public class GestioneDispositiviApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GestioneDispositiviApplication.class, args);
	}
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	DispositivoService disSe;
	
	@Autowired
	RuoloService ruoSe;
	
	ApplicationContext ctx= new AnnotationConfigApplicationContext(GestioneDispositiviConfiguration.class);
	
	@Override
	public void run(String... args) throws Exception {
	
		//METODI PER INSERIRE ELEMENTI NEL DB
//		inserisciRuoli();
//		inserisciUtenti();
//		inserisciDispositivi();
		
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	//INSERIRE RUOLI
	public void inserisciRuoli() {
		
		Ruolo ru1=(Ruolo)ctx.getBean("ru1");
		ruoSe.inserisci(ru1);
		
		Ruolo ru2=(Ruolo)ctx.getBean("ru2");
		ruoSe.inserisci(ru2);
		
	}
	
	//INSERISCE UTENTI
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
	
	//INSERISCE DISPOSITIVI
	public void inserisciDispositivi() {
		
		Dispositivo di1=(Dispositivo)ctx.getBean("di1");
		disSe.inserisci(di1);
		
		Dispositivo di2=(Dispositivo)ctx.getBean("di2");
		disSe.inserisci(di2);
		
		Dispositivo di3=(Dispositivo)ctx.getBean("di3");
		disSe.inserisci(di3);
		
		Dispositivo di4=(Dispositivo)ctx.getBean("di4");
		disSe.inserisci(di4);
		
		Dispositivo di5=(Dispositivo)ctx.getBean("di5");
		disSe.inserisci(di5);
		
		Dispositivo di6=(Dispositivo)ctx.getBean("di6");
		disSe.inserisci(di6);
		
		Dispositivo di7=(Dispositivo)ctx.getBean("di7");
		disSe.inserisci(di7);
		
		Dispositivo di8=(Dispositivo)ctx.getBean("di8");
		disSe.inserisci(di8);
		
	}

}
