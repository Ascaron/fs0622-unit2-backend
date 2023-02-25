package com.epicode.andreacursi.controlloincendi;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.andreacursi.controlloincendi.configuration.ControlloIncendiConfiguration;
import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;
import com.epicode.andreacursi.controlloincendi.observer.CentroDiControllo;
import com.epicode.andreacursi.controlloincendi.observer.IncendioSubject;
import com.epicode.andreacursi.controlloincendi.services.IncendioService;
import com.epicode.andreacursi.controlloincendi.services.SondaService;

@SpringBootApplication
public class ControlloIncendiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlloIncendiApplication.class, args);
	}
	
	@Autowired
	SondaService soSe;
	
	@Autowired
	IncendioService inSe;
	
	ApplicationContext ctx = 
			new AnnotationConfigApplicationContext(ControlloIncendiConfiguration.class);

	@Override
	public void run(String... args) throws Exception {
		
		//Metodi per l'inserimento nel database
//		inserisciSonde();
//		inserisciIncendi();
		
		//Metodo per la visualizzazione su console
		gestioneIncendi();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	public void inserisciSonde() {
		
		Sonda so1=(Sonda)ctx.getBean("so1");
		soSe.inserisci(so1);
		
		Sonda so2=(Sonda)ctx.getBean("so2");
		soSe.inserisci(so2);
		
		Sonda so3=(Sonda)ctx.getBean("so3");
		soSe.inserisci(so3);
		
		Sonda so4=(Sonda)ctx.getBean("so4");
		soSe.inserisci(so4);
		
		Sonda so5=(Sonda)ctx.getBean("so5");
		soSe.inserisci(so5);
		
	}
	
	public void inserisciIncendi() {
		Incendio in1=(Incendio)ctx.getBean("in1");
		inSe.inserisci(in1);
		
		Incendio in2=(Incendio)ctx.getBean("in2");
		inSe.inserisci(in2);
		
		Incendio in3=(Incendio)ctx.getBean("in3");
		inSe.inserisci(in3);
		
		Incendio in4=(Incendio)ctx.getBean("in4");
		inSe.inserisci(in4);
		
		Incendio in5=(Incendio)ctx.getBean("in5");
		inSe.inserisci(in5);
		
		Incendio in6=(Incendio)ctx.getBean("in6");
		inSe.inserisci(in6);
		
	}
	
	public void gestioneIncendi() {
		CentroDiControllo cdc= new CentroDiControllo();
		
		Incendio in1= inSe.ottieniDaId(1).get();
		IncendioSubject inSu1= new IncendioSubject(in1, new ArrayList<>(Arrays.asList(cdc)));
		
		Incendio in2= inSe.ottieniDaId(2).get();
		IncendioSubject inSu2= new IncendioSubject(in2, new ArrayList<>(Arrays.asList(cdc)));
		
		Incendio in3= inSe.ottieniDaId(3).get();
		IncendioSubject inSu3= new IncendioSubject(in3, new ArrayList<>(Arrays.asList(cdc)));
		
		Incendio in4= inSe.ottieniDaId(4).get();
		IncendioSubject inSu4= new IncendioSubject(in4, new ArrayList<>(Arrays.asList(cdc)));
		
		Incendio in5= inSe.ottieniDaId(5).get();
		IncendioSubject inSu5= new IncendioSubject(in5, new ArrayList<>(Arrays.asList(cdc)));
		
		Incendio in6= inSe.ottieniDaId(6).get();
		IncendioSubject inSu6= new IncendioSubject(in6, new ArrayList<>(Arrays.asList(cdc)));
		
		System.out.println("");
		inSu1.segnalaIncendi(in1);
		System.out.println("");
		inSu2.segnalaIncendi(in2);
		System.out.println("");
		inSu3.segnalaIncendi(in3);
		System.out.println("");
		inSu4.segnalaIncendi(in4);
		System.out.println("");
		inSu5.segnalaIncendi(in5);
		System.out.println("");
		inSu6.segnalaIncendi(in6);
		System.out.println("");
	}

}
