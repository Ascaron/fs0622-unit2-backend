package it.gestione.eventi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.gestione.eventi.model.TipoEvento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="evento")
@Getter
@Setter
@ToString
@Entity
public class Evento {

	@Id
	@SequenceGenerator(name="evento_seq", sequenceName="evento_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="evento_seq")
	private int id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;
	@OneToMany(mappedBy="evento", cascade=CascadeType.REMOVE)
	private Set<Partecipazione> partecipazione;
	@ManyToOne
	private Location location;
	
}
