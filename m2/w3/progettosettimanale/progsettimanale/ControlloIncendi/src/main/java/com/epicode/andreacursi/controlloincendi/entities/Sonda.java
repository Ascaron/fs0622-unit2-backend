package com.epicode.andreacursi.controlloincendi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
public class Sonda{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double latitudine;
	private double longitudine;
	
}
