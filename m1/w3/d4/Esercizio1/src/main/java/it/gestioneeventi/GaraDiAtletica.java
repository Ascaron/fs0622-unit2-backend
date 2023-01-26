package it.gestioneeventi;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="gara_di_atletica")
@Getter
@Setter
@ToString
@Entity

//- getGareDiAtleticaPerVincitore(Persona vincitore)
//- getGareDiAtleticaPerPartecipante(Persona partecipante)

@NamedQuery(name = "getGareDiAtleticaPerVincitore", query = "SELECT a FROM GaraDiAtletica a "
		+ "WHERE a.vincitore = :valore")
@NamedQuery(name = "getGareDiAtleticaPerPartecipante", query = "SELECT a FROM GaraDiAtletica a "
		+ "WHERE :valore MEMBER OF a.setAtleti")
public class GaraDiAtletica extends Evento{

	@ManyToMany
	private Set<Persona> setAtleti;
	@ManyToOne
	private Persona vincitore;
	
}
