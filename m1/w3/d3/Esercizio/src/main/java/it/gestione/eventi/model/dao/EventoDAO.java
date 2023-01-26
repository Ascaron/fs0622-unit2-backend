package it.gestione.eventi.model.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestione.eventi.Evento;
import it.gestione.eventi.model.TipoEvento;

public class EventoDAO {

	private static final String gestioneEventi = "M1w3d3es1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneEventi);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void save(Evento object) {
		
		try {
			Evento ev = object;
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell' evento");
		}

	}
	
	public static void ottieniEventoDaId(int id) {
		Evento ev = em.find(Evento.class, id);
		
		if( ev == null ) {
			System.out.println( "L' evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati evento #" + id );
		System.out.printf(  
			"Titolo: %s | Data evento: %s | Descrizione: %s | Tipo evento: %s | Num max partecipanti: %d",
			ev.getTitolo(),ev.getDataEvento(),ev.getDescrizione(),ev.getTipoEvento(),
			ev.getNumeroMassimoPartecipanti()
		);
	}
	
	public static void eliminaEvento(int id) {
		Evento ev = em.find(Evento.class, id);
		
		if( ev == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(ev);
		t.commit();
		
		System.out.println( "L'evento con l'id " + id + " è stato eliminato!" );
	}
	
	public static void modificaEvento(int id, String titolo, LocalDate dataEvento, String descrizione, 
			TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		Evento ev = ottieniEvento(id);
		if( ev == null ) return;
		
		try {
			ev.setTitolo(titolo);
			ev.setDataEvento(dataEvento);
			ev.setDescrizione(descrizione);
			ev.setTipoEvento(tipoEvento);
			ev.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			
			persist(ev);
			
			System.out.println("L'evento con l'id " + id + " è stato modificato!");
		}
		catch(Exception e) {
			System.out.println( "Errore nella modifica dell'evento!" );
		}
		
	}
	
	public static Evento ottieniEvento(int id) {
		Evento ev = em.find(Evento.class, id);
		
		if( ev == null ) {
			System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
			return null;
		}
		
		return ev;
	}
	
	public void refresh(Evento object) {
		try {
			em.refresh(object);
		}
		finally {
			em.close();
		}
	}
	
	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}
}
