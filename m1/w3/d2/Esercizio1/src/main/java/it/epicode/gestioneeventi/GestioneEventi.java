package it.epicode.gestioneeventi;

import java.time.LocalDate;

import it.epicode.gestioneeventi.model.TipoEvento;
import it.epicode.gestioneeventi.model.dao.EventoDAO;

public class GestioneEventi extends EventoDAO {

	public static void main(String[] args) {
		
		//save("CENONE", LocalDate.of(1982, 1, 1), "Molto bello", TipoEvento.PUBBLICO, 5000);
		//save("Concerto", LocalDate.of(1983, 2, 2), "Molto coinvolgente", TipoEvento.PUBBLICO, 500);
		//save("Convegno", LocalDate.of(1990, 2, 3), "Molto bello", TipoEvento.PUBBLICO, 5000);
		
		//ottieniEventoDaId(1);
		//eliminaEvento(3);
		//modificaEvento(2, "Matrimonio", LocalDate.of(1983, 2, 2), "Molto coinvolgente", TipoEvento.PRIVATO, 500);
	}

}
