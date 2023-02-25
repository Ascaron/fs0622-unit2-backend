package com.epicode.andreacursi.controlloincendi.observer;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;

public class CentroDiControllo implements IncendioObserver{

	@Override
	public String segnala(Incendio incendio) {
		if(incendio.getQuantitaFumo()>5) {
			Sonda son=incendio.getSonda();
			String stringa1="http://localhost:8080/";
			String stringa2="alarm/?idsonda="+son.getId()+
					"&lat="+son.getLatitudine()+"&lon="+son.getLongitudine()+"&smokelevel"
					+ "="+incendio.getQuantitaFumo();
			System.out.println(stringa1+stringa2);
			return stringa2;
		}
		System.out.println("Nulla da segnalare");
		return "http://localhost:8080";
	}
	
}
