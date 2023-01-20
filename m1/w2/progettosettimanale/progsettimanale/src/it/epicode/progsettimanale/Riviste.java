package it.epicode.progsettimanale;

import java.time.Year;

public class Riviste {

	private long codiceISBN;
	private String titolo;
	private Year annoPubblicazione;
	private int numeroPagine;
	private Periodicita periodicita;
	
	public Riviste(long codiceISBN, String titolo, Year annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		this.codiceISBN=codiceISBN;
		this.titolo=titolo;
		this.annoPubblicazione=annoPubblicazione;
		this.numeroPagine=numeroPagine;
		this.periodicita=periodicita;
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
	public Periodicita getPeriodicita() {
		return periodicita;
	}

}
