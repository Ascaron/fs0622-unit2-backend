package it.gestionearchivio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="prestito")
@Getter
@Setter
@ToString
@Entity
@NamedQuery(name = "ottieniPrestitoDaTessera", query = "SELECT p FROM Prestito p WHERE p.utente.id = :valore")
public class Prestito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private ArticoloPubblicato elementoPrestato;
	@Column(name="data_inizio_prestito")
	private LocalDate dataInizioPrestito;
	@Column(name="data_restituzione_prevista")
	private LocalDate dataRestituzionePrevista;
	@Column(name="data_restituzione_effettiva")
	private LocalDate dataRestituzioneEffettiva;
	
}
