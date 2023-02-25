package com.andreacursi.designpattern.composite;

import java.util.List;

public class SottoSezione extends Contenuto{
	
	private String titolo;
	private List<Pagina> pagine;
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Pagina> getPagine() {
		return pagine;
	}

	public void setPagine(List<Pagina> pagine) {
		this.pagine = pagine;
	}

	@Override
	public void stampa() {
		System.out.println("Sotto sezione "+titolo);
		
	}

	@Override
	public int getNumeroPagina() {
		int numero=0;
		for(int i=0; i<=getPagine().size(); i++ ) {
			numero=numero+1;
		}
		return numero;
	}
	
}
