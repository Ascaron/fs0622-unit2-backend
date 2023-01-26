package it.gestione.eventi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestione.eventi.Partecipazione;

public class PartecipazioneDAO {

	private static final String gestioneEventi = "M1w3d3es1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneEventi);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(Partecipazione object) {
		
		try {
			Partecipazione pa=object;
			
			t.begin();
			em.persist(pa);
			t.commit();
			
			System.out.println("Partecipazione inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della partecipazione");
		}
	}
	
	public static void ottieniPartecipazioneDaId(int id) {
		Partecipazione pa = em.find(Partecipazione.class, id);
		
		if(pa == null ) {
			System.out.println( "La partecipazione con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		System.out.println( "Dati partecipazione #" + id );
	}
	
	public static void eliminaPartecipazione(int id) {
		Partecipazione pa = em.find(Partecipazione.class, id);
		
		if( pa == null ) {
			System.out.println( "La partecipazione con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		t.begin();
		em.remove(pa);
		t.commit();
		
		System.out.println( "La partecipazione con l'id " + id + " è stata eliminata!" );
	}
	
	public static void modificaPartecipazione(Partecipazione object) {
		Partecipazione pa = ottieniPartecipazione(object.getId());
		if( pa == null ) return;
		
		try {
			pa.setPersona(object.getPersona());
			pa.setEvento(object.getEvento());
			pa.setStato(object.getStato());
			
			persist(pa);
			
			System.out.println("La partecipazione con l'id " + object.getId() + " è stata modificata!");
		}
		catch(Exception e) {
			System.out.println( "Errore nella modifica della partecipazione!" );
		}
		
	}
	
	public static Partecipazione ottieniPartecipazione(int id) {
		Partecipazione pa = em.find(Partecipazione.class, id);
		
		if( pa == null ) {
			System.out.println( "La partecipazione con l'id " + id + " non è stata trovata!" );
			return null;
		}
		
		return pa;
	}
	
	public void refresh(Partecipazione object) {
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
