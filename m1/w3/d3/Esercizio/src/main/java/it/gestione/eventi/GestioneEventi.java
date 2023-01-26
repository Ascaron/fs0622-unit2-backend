package it.gestione.eventi;

import java.time.LocalDate;

import it.gestione.eventi.model.Sesso;
import it.gestione.eventi.model.Stato;
import it.gestione.eventi.model.TipoEvento;
import it.gestione.eventi.model.dao.EventoDAO;
import it.gestione.eventi.model.dao.LocationDAO;
import it.gestione.eventi.model.dao.PartecipazioneDAO;
import it.gestione.eventi.model.dao.PersonaDAO;

public class GestioneEventi{

	public static void main(String[] args) {

		Location loc=ottieniLocation();
		LocationDAO.save(loc);
		Evento ev=ottieniEvento(loc);
		EventoDAO.save(ev);
		Persona per=ottieniPersona();
		PersonaDAO.save(per);
		Partecipazione partec=ottieniPartecipazione(per, ev);
		PartecipazioneDAO.save(partec);

	}
	
	public static Location ottieniLocation() {
		Location l=new Location();
		l.setCitta("Follonica");
		l.setNome("Parco");
		return l;
	}
	
	public static Evento ottieniEvento(Location l) {
		Evento e= new Evento();
		e.setTitolo("FestAmbiente");
		e.setDataEvento(LocalDate.of(2022, 8, 15));
		e.setDescrizione("Concerto all'aperto");
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
	
	private static Partecipazione ottieniPartecipazione(Persona p, Evento e ) {
		Partecipazione pa=new Partecipazione();
		pa.setPersona(p);
		pa.setEvento(e);
		pa.setStato(Stato.CONFERMATA);
		return pa;
	}

}
