package it.gestionearchivio.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="utente")
@Getter
@Setter
@ToString
@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	@Column(name="data_nascita")
	private LocalDate dataNascita;
	@Column(name="numero_tessere")
	private int numeroTessera;
	@OneToMany(mappedBy="utente", fetch =FetchType.LAZY)
	private List<Prestito> prestiti;
	
}
