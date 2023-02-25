package com.andreacursi.designpattern.adapter;

import java.time.LocalDate;
import java.util.Date;

public class Adapter implements DataSource{

	private Info info;
	
	public Adapter(Info info) {
		this.info=info;
	}
	
	@Override
	public String getNomeCompleto() {
		return this.info.getNome()+" "+this.info.getCognome();
	}

	@Override
	public int getEta() {
		return LocalDate.now().getYear()-this.info.getDataDiNascita().getYear();
	}

}
