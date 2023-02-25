package com.epicode.andreacursi.controlloincendi.observer;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;

public interface IncendioObserver {

	String segnala(Incendio incendio);
	
}
