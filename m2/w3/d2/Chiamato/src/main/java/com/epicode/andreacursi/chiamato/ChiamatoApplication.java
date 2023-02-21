package com.epicode.andreacursi.chiamato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.chiamato.configuration.ChiamatoConfiguration;
import com.epicode.andreacursi.chiamato.entities.Persona;
import com.epicode.andreacursi.chiamato.services.PersonaService;

@SpringBootApplication
public class ChiamatoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChiamatoApplication.class, args);
	}

	@Autowired
	PersonaService perSe;
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(ChiamatoConfiguration.class);
	
	@Override
	public void run(String... args) throws Exception {
		
//		inserisciPersone();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

	public void inserisciPersone() {
		
		Persona p1=(Persona)ctx.getBean("p1");
		perSe.inserisci(p1);
		
		Persona p2=(Persona)ctx.getBean("p2");
		perSe.inserisci(p2);
		
		Persona p3=(Persona)ctx.getBean("p3");
		perSe.inserisci(p3);
		
		Persona p4=(Persona)ctx.getBean("p4");
		perSe.inserisci(p4);
		
	}
	
}
