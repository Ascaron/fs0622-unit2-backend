package it.gestionearchivio.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("Libri")
@NoArgsConstructor
@NamedQuery(name = "ottieniElementoDaAutore", query = "SELECT l FROM Libri l WHERE l.autore = :valore")
public class Libri extends ArticoloPubblicato{

	private String autore;
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	public Libri(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore,
			Genere genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore=autore;
		this.genere=genere;
	}
}
