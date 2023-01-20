package it.epicode.progsettimanale;

import java.time.Year;

public class Libri {

	private long codiceISBN;
	private String titolo;
	private Year annoPubblicazione;
	private int numeroPagine;
	private Autore autore;
	private Genere genere;
	
	public Libri(long codiceISBN, String titolo, Year annoPubblicazione, int numeroPagine, Autore autore, Genere genere) {
		this.codiceISBN=codiceISBN;
		this.titolo=titolo;
		this.annoPubblicazione=annoPubblicazione;
		this.numeroPagine=numeroPagine;
		this.autore=autore;
		this.genere=genere;
	}
	
	public long getCodiceISBN() {
		return codiceISBN;
	}
	public String getTitolo() {
		return titolo;
	}
	public Year getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public Autore getAutore() {
		return autore;
	}
	public Genere getGenere() {
		return genere;
	}
	
}
