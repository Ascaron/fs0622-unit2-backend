package it.gestionearchivio.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.gestionearchivio.model.Libri;

public class LibriDAO {

	private static final String gestioneArchivio = "M1w3progsettimanale";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneArchivio);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	
	public static void save(Libri object) {
		
		try {
			Libri l = object;
			
			t.begin();
			em.persist(l);
			t.commit();
			
			System.out.println("Libro inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento del libro");
		}

	}
	
    public static void ottieniElementoDaAutore(String autore) {
    	
    	Query q = em.createNamedQuery("ottieniElementoDaAutore");
    	q.setParameter("valore", autore);
    	
    	List<Libri> res = q.getResultList();
    	
    	for(Libri l:res) {
    		System.out.println(l);
    	}
    	
    }
}
