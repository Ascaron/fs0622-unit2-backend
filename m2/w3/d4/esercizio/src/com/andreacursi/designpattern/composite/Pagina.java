package com.andreacursi.designpattern.composite;

public class Pagina extends Contenuto{

	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public int getNumeroPagina() {
		return 1;
	}

	@Override
	public void stampa() {
		System.out.println("Pagina numero"+ numero);
		
	}
	
}
