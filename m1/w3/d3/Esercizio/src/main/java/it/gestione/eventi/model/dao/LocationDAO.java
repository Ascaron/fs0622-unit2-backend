package it.gestione.eventi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestione.eventi.Location;

public class LocationDAO {

	private static final String gestioneEventi = "M1w3d3es1";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneEventi);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(Location object) {
		
		try {
			Location l=object;
			
			t.begin();
			em.persist(l);
			t.commit();
			
			System.out.println("Location inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della location");
		}
	}
	
	public static void ottieniLocationDaId(int id) {
		Location l = em.find(Location.class, id);
		
		if(l == null ) {
			System.out.println( "La location con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		System.out.println( "Dati location #" + id );
	}
	
	public static void eliminaLocation(int id) {
		Location l = em.find(Location.class, id);
		
		if( l == null ) {
			System.out.println( "La location con l'id " + id + " non è stata trovata!" );
			return;
		}
		
		t.begin();
		em.remove(l);
		t.commit();
		
		System.out.println( "La location con l'id " + id + " è stata eliminata!" );
	}
	
	public static void modificaLocation(Location object) {
		Location l = ottieniLocation(object.getId());
		if( l == null ) return;
		
		try {
			l.setNome(object.getNome());
			l.setCitta(object.getCitta());
			
			persist(l);
			
			System.out.println("La location con l'id " + object.getId() + " è stata modificata!");
		}
		catch(Exception e) {
			System.out.println( "Errore nella modifica della location!" );
		}
		
	}
	
	public static Location ottieniLocation(int id) {
		Location l = em.find(Location.class, id);
		
		if( l == null ) {
			System.out.println( "La location con l'id " + id + " non è stata trovata!" );
			return null;
		}
		
		return l;
	}
	
	public void refresh(Location object) {
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
