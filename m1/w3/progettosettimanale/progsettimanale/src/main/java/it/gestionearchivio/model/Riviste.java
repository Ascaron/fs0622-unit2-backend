package it.gestionearchivio.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("Riviste")
@NoArgsConstructor
public class Riviste extends ArticoloPubblicato{

	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	
	public Riviste(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine,
			Periodicita periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita=periodicita;
	}
	
}
