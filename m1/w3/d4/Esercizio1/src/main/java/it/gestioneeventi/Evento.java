package it.gestioneeventi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.gestioneeventi.model.TipoEvento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="evento")
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "getEventiSoldOut", query = "SELECT e FROM Evento e WHERE "
		+ "SIZE(e.partecipazione) >= e.numeroMassimoPartecipanti")
@NamedQuery(name = "getEventiPerInvitato", query = "SELECT e FROM Evento e WHERE EXISTS(SELECT 1 FROM "
		+ "e.setPartecipazioni p WHERE p.persona= :persona")
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
