package com.andreacursi.gestioneprenotazioni;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andreacursi.gestioneprenotazioni.config.GestionePrenotazioniConfiguration;
import com.andreacursi.gestioneprenotazioni.dao.EdificioRepository;
import com.andreacursi.gestioneprenotazioni.dao.EdificioService;
import com.andreacursi.gestioneprenotazioni.dao.PostazioneRepository;
import com.andreacursi.gestioneprenotazioni.dao.PostazioneService;
import com.andreacursi.gestioneprenotazioni.dao.PrenotazioniRepository;
import com.andreacursi.gestioneprenotazioni.dao.PrenotazioniService;
import com.andreacursi.gestioneprenotazioni.dao.UtenteRepository;
import com.andreacursi.gestioneprenotazioni.dao.UtenteService;
import com.andreacursi.gestioneprenotazioni.entity.Edificio;
import com.andreacursi.gestioneprenotazioni.entity.Postazione;
import com.andreacursi.gestioneprenotazioni.entity.Prenotazioni;
import com.andreacursi.gestioneprenotazioni.entity.Utente;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}
	
	@Autowired
	EdificioService ediSe;
	
	@Autowired
	PostazioneService posSe;
	
	@Autowired
	PrenotazioniService preSe;
	
	@Autowired
	UtenteService uteSe;
	
	@Autowired
	private EdificioRepository ediRepo;
	
	@Autowired
	private PostazioneRepository posRepo;
	
	@Autowired
	private UtenteRepository utRepo;
	
	@Autowired
	PrenotazioniRepository preRepo;
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniConfiguration.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		//Inserimento dati nel database
		inserisciEdifici();
		inserisciPostazioni();
		inserisciUtenti();
		inserisciPrenotazioni();

		
		//Ricerca postazione per tipo
//		trovaPostazioneDaTipo("OPENSPACE");
		
		//Ricerca postazione per citta
//		trovaPostazioneDaCitta("Roma");
		
		//Prenota una postazione
//		prePrenota();

		
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
	
	public void inserisciPostazioni() {
		Postazione po1=(Postazione)ctx.getBean("po1");
		posSe.inserisciPos(po1);
		
		Postazione po2=(Postazione)ctx.getBean("po2");
		posSe.inserisciPos(po2);
		
		Postazione po3=(Postazione)ctx.getBean("po3");
		posSe.inserisciPos(po3);
		
		Postazione po4=(Postazione)ctx.getBean("po4");
		posSe.inserisciPos(po4);
		
		Postazione po5=(Postazione)ctx.getBean("po5");
		posSe.inserisciPos(po5);
	}
	
	public void inserisciUtenti() {
		Utente ut1=(Utente)ctx.getBean("ut1");
		uteSe.inserisciUte(ut1);
		
		Utente ut2=(Utente)ctx.getBean("ut2");
		uteSe.inserisciUte(ut2);
		
		Utente ut3=(Utente)ctx.getBean("ut3");
		uteSe.inserisciUte(ut3);
		
		Utente ut4=(Utente)ctx.getBean("ut4");
		uteSe.inserisciUte(ut4);
	}
	
	public void inserisciPrenotazioni() {
		Prenotazioni pr1=(Prenotazioni)ctx.getBean("pr1");
		preSe.inserisciPre(pr1);
		
		Prenotazioni pr2=(Prenotazioni)ctx.getBean("pr2");
		preSe.inserisciPre(pr2);
		
		Prenotazioni pr3=(Prenotazioni)ctx.getBean("pr3");
		preSe.inserisciPre(pr3);
	}
	
	
	//Ricerca postazione per tipo
	public void trovaPostazioneDaTipo(String tipo) {
		posRepo.findByTipo(tipo).forEach((pos)->{
			System.out.println("-----------");
			System.out.println(pos.getCodice()+" "+pos.getDescrizione());
			System.out.println("-----------");
		});
		
	}
	
	//Ricerca postazione per città
	public void trovaPostazioneDaCitta(String citta) {
		List<Edificio> edi = new ArrayList<Edificio>();
		ediRepo.findByCitta(citta).forEach((el)->{
			edi.add(el);
		});
		List<Integer> ide=new ArrayList<Integer>();
		edi.forEach((el)->{
			ide.add(el.getId());
		});
		List<Postazione> pos=new ArrayList<Postazione>();
		ide.forEach((el)->{
			pos.addAll(posRepo.cercaDaEdificioId(el));
		});
		pos.forEach((el)->{
			System.out.println("-----------");
			System.out.println(el.getCodice()+" "+el.getDescrizione());
			System.out.println("-----------");
		});
	}
	
	//Prenota postazione (inserire nei campi id utente, id postazione esistenti nel
	//database e data
	public void prePrenota() {

		List<Utente> lisUt=new ArrayList<Utente>();
		utRepo.cercaDaId(4).forEach((el)->{
			lisUt.add(el);
		});

		List<Postazione> lisPos=new ArrayList<Postazione>();
		posRepo.cercaDaId(5).forEach((el)->{
			lisPos.add(el);
		});
		int pos=lisPos.get(0).getId();
		int ut=lisUt.get(0).getId();
		LocalDate data=LocalDate.of(2023, 7, 7);
		prenota(data, ut, pos);
	}
	
	public void prenota(LocalDate data, int utente, int postazione) {
		List<Prenotazioni> pre=new ArrayList<Prenotazioni>();
		preRepo.findByDataPrenotazione(data).forEach((el)->{
			pre.add(el);
		});
		if(pre.isEmpty()) {
			System.out.println("In questa data non ci sono prenotazioni");
		}
		else {
			List<Prenotazioni> pre2=new ArrayList<Prenotazioni>();
			pre.forEach((el)->{
				if(el.getId()!=utente) {
					pre2.add(el);
					prenotaSeconda(data, utente, postazione, pre2);
				}
				else {
					System.out.println("Non puoi prenotare, hai già prenotato");
				}
			});
		}
	}
	
	public void prenotaSeconda(LocalDate data,int utente,int postazione, List<Prenotazioni> pre) {
		pre.forEach((el)->{
			if(el.getId()!=postazione) {
				System.out.println("In questa postazione non ci sono prenotazioni");
			}
			else {
				System.out.println("Non puoi prenotare, è occupata");
			}
		});
	}

}
