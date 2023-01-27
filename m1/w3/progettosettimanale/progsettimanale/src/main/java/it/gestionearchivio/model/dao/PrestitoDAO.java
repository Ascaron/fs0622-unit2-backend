package it.gestionearchivio.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.gestionearchivio.model.Prestito;

public class PrestitoDAO {

	private static final String gestioneArchivio = "M1w3progsettimanale";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneArchivio);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

	public static void save(Prestito object) {

		Prestito p = object;

		System.out.println("Prestito inserito correttamente!");
		try {
			t.begin();
			em.persist(p);
			t.commit();
		} catch (Exception e) {
			System.out.println("Errore nell'inserimento del prestito");
		}

	}
	
	 public static void ottieniPrestitoDaTessera(int numeroTessera) {
	    	
	    	Query q = em.createNamedQuery("ottieniPrestitoDaTessera");
	    	q.setParameter("valore", numeroTessera);
	    	
	    	List<Prestito> res = q.getResultList();
	    	
	    	for(Prestito p:res) {
	    		System.out.println("Id del prestito: "+ p.getId());
	    	}
	    	
	    }

}
