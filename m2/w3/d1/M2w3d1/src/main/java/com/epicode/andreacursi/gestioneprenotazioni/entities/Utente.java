package com.epicode.andreacursi.gestioneprenotazioni.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.epicode.andreacursi.gestioneprenotazioni.configuration.StringAttributeConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String nomeCompleto;
	private String email;
	//SOTTO DA COMMENTARE SE SI USA IL GIRO DI UserDetailsImpl
	@Convert(converter = StringAttributeConverter.class)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "utenti_ruoli")
	private Set<Ruolo> ruolo = new HashSet<>();
	
}

