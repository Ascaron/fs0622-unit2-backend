package com.andreacursi.designpattern.composite;

import java.util.List;

public class Sezione extends Contenuto {

	private String titolo;
	private List<SottoSezione> sottoSezioni;

	public List<SottoSezione> getSottoSezioni() {
		return sottoSezioni;
	}

	public void setSottoSezioni(List<SottoSezione> sottoSezioni) {
		this.sottoSezioni = sottoSezioni;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public void stampa() {
		System.out.println("Sezione " + titolo);

	}

	@Override
	public int getNumeroPagina() {
		int numero = 0;
		for (int i = 0; i < getSottoSezioni().size(); i++) {
			SottoSezione s = getSottoSezioni().get(i);
			for (int j = 0; j < s.getPagine().size(); j++) {
				numero = numero + 1;
			}
		}
		return numero;
	}

}
