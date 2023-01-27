package it.gestionearchivio.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestionearchivio.model.Riviste;

public class RivisteDAO{
	
	private static final String gestioneArchivio = "M1w3progsettimanale";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneArchivio);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void save(Riviste object) {
		
		try {
			Riviste r = object;
			
			t.begin();
			em.persist(r);
			t.commit();
			
			System.out.println("Rivista inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della rivista");
		}

	}


}
