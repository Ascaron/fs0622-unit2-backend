package com.epicode.andreacursi.controlloincendi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;

@Configuration
public class ControlloIncendiConfiguration {

	//SONDE
	@Bean
	public Sonda so1() {
		Sonda so=Sonda.builder().latitudine(100).longitudine(100).build();
		return so;
	}
	
	@Bean
	public Sonda so2() {
		Sonda so=Sonda.builder().latitudine(200).longitudine(200).build();
		return so;
	}
	
	@Bean
	public Sonda so3() {
		Sonda so=Sonda.builder().latitudine(300).longitudine(300).build();
		return so;
	}
	
	@Bean
	public Sonda so4() {
		Sonda so=Sonda.builder().latitudine(400).longitudine(400).build();
		return so;
	}
	
	@Bean
	public Sonda so5() {
		Sonda so=Sonda.builder().latitudine(500).longitudine(500).build();
		return so;
	}
	
	
	//INCENDI
	@Bean
	public Incendio in1() {
		Incendio in=Incendio.builder().sonda(so1()).quantitaFumo(6).build();
		return in;
	}
	
	@Bean
	public Incendio in2() {
		Incendio in=Incendio.builder().sonda(so2()).quantitaFumo(4).build();
		return in;
	}
	
	@Bean
	public Incendio in3() {
		Incendio in=Incendio.builder().sonda(so3()).quantitaFumo(9).build();
		return in;
	}
	
	@Bean
	public Incendio in4() {
		Incendio in=Incendio.builder().sonda(so4()).quantitaFumo(2).build();
		return in;
	}
	
	@Bean
	public Incendio in5() {
		Incendio in=Incendio.builder().sonda(so5()).quantitaFumo(7).build();
		return in;
	}
	
	@Bean
	public Incendio in6() {
		Incendio in=Incendio.builder().sonda(so1()).quantitaFumo(6).build();
		return in;
	}
	
}
