package it.gestioneeventi;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.gestioneeventi.model.Sesso;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="persona")
@Entity
@Getter
@Setter
@ToString
public class Persona {

	@Id
	@SequenceGenerator(name="persona_seq", sequenceName="persona_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="persona_seq")
	private int id;
	private String nome;
	private String cognome;
	private String email;
	@Column(name="data_nascita")
	private LocalDate dataNascita;
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy ="persona", cascade = CascadeType.REMOVE)
	@OrderBy(value="evento.dataEvento")
	@Column(name="lista_partecipazioni")
	private List <Partecipazione> listaPartecipazioni;
	
}
