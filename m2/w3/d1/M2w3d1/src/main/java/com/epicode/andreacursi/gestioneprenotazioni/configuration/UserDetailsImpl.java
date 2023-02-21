package com.epicode.andreacursi.gestioneprenotazioni.configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{

	private String username;
	private String password;
	private Set<Ruolo> roles;
	
	private boolean accountNonLocked = true;
	private boolean accountNonExpired = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(String username, String password,  Set<Ruolo> roles, List<GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(Utente utente) {
		List<GrantedAuthority> grants = utente.getRuolo().stream()
							.map(ruolo -> new SimpleGrantedAuthority(ruolo.getTipo().name()))
							.collect(Collectors.toList());
		
		return new UserDetailsImpl(utente.getUsername(), utente.getPassword(), utente.getRuolo(), grants);
	}

}
