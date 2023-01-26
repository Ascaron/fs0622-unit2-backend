package it.gestioneeventi;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import it.gestioneeventi.model.Genere;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="concerto")
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "getConcertiInStreaming", query = "SELECT c FROM Concerto c"
		+ " WHERE c.inStreaming = :cs")
@NamedQuery(name = "getConcertiPerGenere", query = "SELECT c FROM Concerto c"
		+ " WHERE c.genere in :listagenere")
public class Concerto extends Evento{

	@Enumerated(EnumType.STRING)
	private Genere genere;
	private boolean inStreaming;
	
}
