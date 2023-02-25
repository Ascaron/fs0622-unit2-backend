package com.andreacursi.designpattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.andreacursi.designpattern.adapter.Adapter;
import com.andreacursi.designpattern.adapter.Info;
import com.andreacursi.designpattern.composite.Libro;
import com.andreacursi.designpattern.composite.Pagina;
import com.andreacursi.designpattern.composite.Sezione;
import com.andreacursi.designpattern.composite.SottoSezione;

public class Main {

	public static void main(String[] args) {

		m1();
		System.out.println("");
		System.out.println("");
		m2();
		System.out.println("");
		System.out.println("");

	}

	public static void m1() {
		Date data = new Date();
		data.setYear(1995);
		data.setMonth(01);
		data.setDate(24);
		Info info = new Info();
		info.setNome("Mario");
		info.setCognome("Rossi");
		info.DataDiNascita(data);
		Adapter ad = new Adapter(info);
		System.out.println(ad.getNomeCompleto());
		System.out.println(ad.getEta());
	}

	public static void m2() {

		Libro libro = new Libro();
		SottoSezione sotSez = new SottoSezione();
		Sezione sez=new Sezione();
		
		List<Pagina> l = new ArrayList<Pagina>();
		for (int i = 1; i <= 10; i++) {
			Pagina p = new Pagina();
			p.setNumero(i);
			l.add(p);
		}
		sotSez.setPagine(l);
		sotSez.setTitolo("sotsez1");
		List<SottoSezione> sose = new ArrayList<SottoSezione>();
		sose.add(sotSez);
		sez.setSottoSezioni(sose);
		sez.setTitolo("Sezione 1");
		List<Sezione> se = new ArrayList<Sezione>();
		se.add(sez);
		libro.setSezioni(se);
		libro.setPrezzo(10);
		libro.setTitolo("Ciao");
		List<String> autori = new ArrayList<String>();
		autori.add("Mario");
		libro.setAutori(autori);
		System.out.println(libro.getNumeroPagina());
		libro.stampa();
	}

}
