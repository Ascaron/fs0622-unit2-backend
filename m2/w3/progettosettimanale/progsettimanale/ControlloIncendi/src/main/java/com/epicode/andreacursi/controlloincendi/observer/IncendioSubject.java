package com.epicode.andreacursi.controlloincendi.observer;

import java.util.ArrayList;
import java.util.List;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncendioSubject {

	private Incendio incendio;
	List<IncendioObserver> osservatori = new ArrayList<>();
	
	public void aggiungiOsservatore(IncendioObserver io) {
		osservatori.add(io);
	}
	
	public void rimuoviOsservatore(IncendioObserver io) {
		osservatori.remove(io);
	}
	
	public void segnalaIncendi(Incendio incendio) {
		if(incendio.getQuantitaFumo()>5) {
			System.out.println("C'é un incendio!");
		}
		osservatori.forEach(osservatore -> osservatore.segnala(incendio));
	}
}
