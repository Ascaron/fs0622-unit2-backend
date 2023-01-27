package it.gestionearchivio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.gestionearchivio.model.ArticoloPubblicato;
import it.gestionearchivio.model.Genere;
import it.gestionearchivio.model.Libri;
import it.gestionearchivio.model.Periodicita;
import it.gestionearchivio.model.Prestito;
import it.gestionearchivio.model.Riviste;
import it.gestionearchivio.model.Utente;
import it.gestionearchivio.model.dao.ArticoloPubblicatoDAO;
import it.gestionearchivio.model.dao.LibriDAO;
import it.gestionearchivio.model.dao.PrestitoDAO;
import it.gestionearchivio.model.dao.RivisteDAO;
import it.gestionearchivio.model.dao.UtenteDAO;

public class GestioneArchivio {
	
	private static final String gestioneArchivio = "M1w3progsettimanale";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(gestioneArchivio);
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction t = em.getTransaction();


	public static void main(String[] args) {
		
		/*Libri l1=new Libri(1111, "libro1", 2002, 100, "autore1", Genere.FANTASY);
		Libri l2=new Libri(1112, "libro2", 2003, 100, "autore2", Genere.GIALLO);
		Libri l3=new Libri(1113, "libro3", 2004, 100, "autore3", Genere.STORIA);
		LibriDAO.save(l1);
		LibriDAO.save(l2);
		LibriDAO.save(l3);
		
		Riviste r1=new Riviste(1114, "rivista1", 2005, 100, Periodicita.MENSILE);
		Riviste r2=new Riviste(1115, "rivista1", 2006, 100, Periodicita.SEMESTRALE);
		Riviste r3=new Riviste(1116, "rivista1", 2007, 100, Periodicita.SETTIMANALE);
		RivisteDAO.save(r1);
		RivisteDAO.save(r2);
		RivisteDAO.save(r3);
		
		Utente u1=new Utente();
		u1.setNome("Mario");
		u1.setCognome("Rossi");
		u1.setDataNascita(LocalDate.of(1980, 5, 5));
		u1.setNumeroTessera(111);
		UtenteDAO.save(u1);
		
		Utente u2=new Utente();
		u2.setNome("Luigi");
		u2.setCognome("Verdi");
		u2.setDataNascita(LocalDate.of(1990, 6, 6));
		u2.setNumeroTessera(111);
		UtenteDAO.save(u2);
		
		Prestito p1=new Prestito();
		p1.setUtente(u1);
		ArticoloPubblicato ap= em.find(ArticoloPubblicato.class, 1);
		p1.setElementoPrestato(ap);
		p1.setDataInizioPrestito(LocalDate.of(2020, 5, 5));
		p1.setDataRestituzionePrevista(p1.getDataInizioPrestito().plusDays(30));
		p1.setDataRestituzioneEffettiva(LocalDate.of(2020, 5, 20));
		PrestitoDAO.save(p1);
		
		Prestito p2=new Prestito();
		p2.setUtente(u2);
		ArticoloPubblicato ap2= em.find(ArticoloPubblicato.class, 1);
		p2.setElementoPrestato(ap2);
		p2.setDataInizioPrestito(LocalDate.of(2020, 7, 7));
		p2.setDataRestituzionePrevista(p2.getDataInizioPrestito().plusDays(30));
		p2.setDataRestituzioneEffettiva(LocalDate.of(2020, 8, 20));
		PrestitoDAO.save(p2);*/
		
		//ArticoloPubblicatoDAO.ottieniElementoDaISBN(1111);
		//ArticoloPubblicatoDAO.ottieniElementoDaAnnoPubblicazione(2002);
		//ArticoloPubblicatoDAO.eliminaArticolo(2);
		//LibriDAO.ottieniElementoDaAutore("Pino");
		//ArticoloPubblicatoDAO.ottieniElementoDaTitolo("Alto");
		//PrestitoDAO.ottieniPrestitoDaTessera(111);
		
	}

}
