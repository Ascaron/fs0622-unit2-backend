package it.gestioneeventi;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="partita_di_calcio")
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE "
		+ "p.squadraVincente = p.squadraDiCasa")
@NamedQuery(name = "getPartiteVinteOspite", query = "SELECT p FROM PartitaDiCalcio p WHERE "
		+ "p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "getPartiteVinteNessuna", query = "SELECT p FROM PartitaDiCalcio p WHERE "
		+ "p.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento{

	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int numeroGolSquadraDiCasa;
	private int numeroGolSquadraOspite;
	
}
