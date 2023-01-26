package it.gestioneeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestioneeventi.model.Genere;
import it.gestioneeventi.model.Sesso;
import it.gestioneeventi.model.Stato;
import it.gestioneeventi.model.TipoEvento;
import it.gestioneeventi.model.dao.EventoDAO;
import it.gestioneeventi.model.dao.LocationDAO;
import it.gestioneeventi.model.dao.PartecipazioneDAO;
import it.gestioneeventi.model.dao.PersonaDAO;

public class GestioneEventi {
	
	private static final String gestioneEventi = "M1w3d4es1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneEventi);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {

		//Location loc=ottieniLocation();
		//LocationDAO.save(loc);
		//Evento ev=ottieniEvento(loc);
		//EventoDAO.save(ev);
		//Persona per=ottieniPersona();
		//Persona per2=ottieniPersona();
		//Persona per3=ottieniPersona();
		//PersonaDAO.save(per);
		//PersonaDAO.save(per2);
		//PersonaDAO.save(per3);
		//Partecipazione partec=ottieniPartecipazione(per, ev);
		//PartecipazioneDAO.save(partec);
		//saveConcerti(loc);
		//savePartita(loc);
		//saveGara(loc, per3);
		EventoDAO.getConcertiInStreaming(true);
		List<Genere> lista= new ArrayList<Genere>();
		lista.add(Genere.CLASSICO);
		EventoDAO.getConcertiPerGenere(lista);
		EventoDAO.getPartiteVinteInCasa();
		EventoDAO.getPartiteVinteOspite();
		EventoDAO.getPartiteVinteNessuna();
		Persona per4=ottieniPersona();
		PersonaDAO.save(per4);

	}
	
	public static Location ottieniLocation() {
		Location l=new Location();
		l.setCitta("Firenze");
		l.setNome("Stadio");
		return l;
	}
	
	public static Evento ottieniEvento(Location l) {
		Evento e= new Evento();
		e.setTitolo("Viva lo Sport");
		e.setDataEvento(LocalDate.of(2022, 8, 15));
		e.setDescrizione("Competizione sportiva");
		e.setTipoEvento(TipoEvento.PUBBLICO);
		e.setNumeroMassimoPartecipanti(5000);;
		e.setLocation(l);
		return e;
	}
	
	public static Persona ottieniPersona() {
		Persona p=new Persona();
		p.setNome("Mario");
		p.setCognome("Rossi");
		p.setEmail("mario@rossi.it");
		p.setDataNascita(LocalDate.of(1980, 9, 5));
		p.setSesso(Sesso.M);
		return p;
		
	}
	
	public static Persona ottieniPersona2() {
		Persona p=new Persona();
		p.setNome("Giovanni");
		p.setCognome("Verdi");
		p.setEmail("giovanni@verdi.it");
		p.setDataNascita(LocalDate.of(1990, 9, 5));
		p.setSesso(Sesso.M);
		return p;
		
	}
	
	public static Persona ottieniPersona3() {
		Persona p=new Persona();
		p.setNome("Marco");
		p.setCognome("Neri");
		p.setEmail("marco@neri.it");
		p.setDataNascita(LocalDate.of(1989, 7, 6));
		p.setSesso(Sesso.M);
		return p;
		
	}
	
	private static Partecipazione ottieniPartecipazione(Persona p, Evento e ) {
		Partecipazione pa=new Partecipazione();
		pa.setPersona(p);
		pa.setEvento(e);
		pa.setStato(Stato.CONFERMATA);
		return pa;
	}
	
	private static void saveConcerti(Location l) {
		Concerto c=new Concerto();
		t.begin();
		c.setTitolo("Concerto");
		c.setDataEvento(LocalDate.of(2022, 5, 5));
		c.setDescrizione("All' aperto");
		c.setTipoEvento(TipoEvento.PUBBLICO);
		c.setNumeroMassimoPartecipanti(5000);
		c.setLocation(l);
		c.setGenere(Genere.ROCK);
		c.setInStreaming(false);
		em.persist(c);
		t.commit();

	}
	
	private static void savePartita(Location l) {
		PartitaDiCalcio p=new PartitaDiCalcio();
		t.begin();
		p.setTitolo("Partita");
		p.setDataEvento(LocalDate.of(2002, 5, 5));
		p.setDescrizione("All' aperto");
		p.setTipoEvento(TipoEvento.PUBBLICO);
		p.setNumeroMassimoPartecipanti(5000);
		p.setLocation(l);
		p.setSquadraDiCasa("Fiorentina");
		p.setSquadraOspite("Juventus");
		p.setSquadraVincente("Fiorentina");
		p.setNumeroGolSquadraDiCasa(4);
		p.setNumeroGolSquadraOspite(2);
		em.persist(p);
		t.commit();
	}
	
	private static void saveGara(Location l, Persona p) {
		GaraDiAtletica g=new GaraDiAtletica();
		t.begin();
		g.setTitolo("Gara");
		g.setDataEvento(LocalDate.of(2000, 5, 5));
		g.setDescrizione("All' aperto");
		g.setTipoEvento(TipoEvento.PUBBLICO);
		g.setNumeroMassimoPartecipanti(500);
		g.setLocation(l);
		g.setVincitore(p);
		em.persist(g);
		t.commit();
	}

}
