package com.epicode.andreacursi.gestionedispositivi.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.andreacursi.gestionedispositivi.model.StatoManutenzione;
import com.epicode.andreacursi.gestionedispositivi.model.TipoDispositivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipo;
	@Enumerated(EnumType.STRING)
	private StatoManutenzione stato;
	@ManyToOne
	private Utente utente;
	
}
