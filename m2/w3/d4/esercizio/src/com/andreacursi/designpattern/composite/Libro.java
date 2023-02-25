package com.andreacursi.designpattern.composite;

import java.util.List;

public class Libro extends Contenuto{

	private List<Sezione> sezioni;
	private List<String> autori;
	private String titolo;
	private double prezzo;
	

	public List<Sezione> getSezioni() {
		return sezioni;
	}
	public void setSezioni(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}
	public List<String> getAutori() {
		return autori;
	}
	public void setAutori(List<String> autori) {
		this.autori = autori;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public void stampa() {
		System.out.println("Libro "+titolo);
		
	}
	@Override
	public int getNumeroPagina() {
		int numero = 0;
		for(int k=0; k<getSezioni().size(); k++) {
			Sezione se=getSezioni().get(k);
			for (int i = 0; i < se.getSottoSezioni().size(); i++) {
				SottoSezione s = se.getSottoSezioni().get(i);
				for (int j = 0; j < s.getPagine().size(); j++) {
					numero = numero + 1;
				}
			}
		}
		return numero;
	}
	
}
