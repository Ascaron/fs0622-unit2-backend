package it.gestioneeventi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestioneeventi.Persona;

public class PersonaDAO {

	private static final String gestioneEventi = "M1w3d4es1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneEventi);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(Persona object) {
		
		try {
			Persona p = object;
			
			t.begin();
			em.persist(p);
			t.commit();
			
			System.out.println("Persona inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della persona");
		}
	}
	
	public static void ottieniPersonaDaId(int id) {
		Persona p = em.find(Persona.class, id);
		
		if( p == null ) {
			System.out.println( "La persona con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		System.out.println( "Dati persona #" + id );
	}
	
	public static void eliminaPersona(int id) {
		Persona p = em.find(Persona.class, id);
		
		if( p == null ) {
			System.out.println( "La persona con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		t.begin();
		em.remove(p);
		t.commit();
		
		System.out.println( "La persona con l'id " + id + " è stata eliminata!" );
	}
	
	public static void modificaPersona(Persona object) {
		Persona p = ottieniPersona(object.getId());
		if( p == null ) return;
		
		try {
			p.setNome(object.getNome());
			p.setCognome(object.getCognome());
			p.setEmail(object.getEmail());
			p.setDataNascita(object.getDataNascita());
			p.setSesso(object.getSesso());
			p.setListaPartecipazioni(object.getListaPartecipazioni());
			
			persist(p);
			
			System.out.println("La persona con l'id " + object.getId() + " è stata modificata!");
		}
		catch(Exception e) {
			System.out.println( "Errore nella modifica della persona!" );
		}
		
	}
	
	public static Persona ottieniPersona(int id) {
		Persona p = em.find(Persona.class, id);
		
		if( p == null ) {
			System.out.println( "La persona con l'id " + id + " non è stata trovata!" );
			return null;
		}
		
		return p;
	}
	
	public void refresh(Persona object) {
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
