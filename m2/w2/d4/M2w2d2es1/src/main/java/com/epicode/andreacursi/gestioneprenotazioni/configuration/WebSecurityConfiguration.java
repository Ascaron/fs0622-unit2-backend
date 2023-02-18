package com.epicode.andreacursi.gestioneprenotazioni.configuration;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.epicode.andreacursi.gestioneprenotazioni.model.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.model.TipoDiRuolo;
import com.epicode.andreacursi.gestioneprenotazioni.model.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.services.UtenteService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration{
	
	@Autowired
	private UtenteService uteSe;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().requestMatchers("/", "/saluto", "/lingua").permitAll()
//				.anyRequest().authenticated().and().formLogin()
//				.successForwardUrl("/login_success").and().logout().and().csrf().disable();
//	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests().requestMatchers("/", "/saluto", "/lingua").permitAll().anyRequest().authenticated()
            .and().formLogin().successForwardUrl("/login_success").and().logout().and().csrf().disable();
        return http.build();
    }
	
	
	
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		Optional<Utente> autoUtenteObj = uteSe.ottieniUtenteDaId(1);
//		Utente autoUtente = autoUtenteObj.get();
//		String ruolo = "USER";
//		Set<Ruolo> ruoli = autoUtente.getRuolo();
//		
//		for( Ruolo r : ruoli ) {
//			if( r.getTipo().toString().contains("ADMIN") ) {
//				ruolo = "ADMIN";
//				break;
//			}
//		}
//		
//		auth.inMemoryAuthentication()
//			.withUser( autoUtente.getUsername() ).password( passwordEncoder().encode( autoUtente.getPassword() ) )
//			.roles(ruolo);
//	}
	
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	
		Optional<Utente> autoUtenteObj = uteSe.ottieniUtenteDaId(2);
		Utente autoUtente = autoUtenteObj.get();
		String ruolo = "USER";
		Set<Ruolo> ruoli = autoUtente.getRuolo();
		TipoDiRuolo tipoA= TipoDiRuolo.ROLE_ADMIN;
		TipoDiRuolo tipoU= TipoDiRuolo.ROLE_USER;
		
		for( Ruolo r : ruoli ) {
			System.out.println(r.getTipo().toString());
			if( r.getTipo().equals(tipoA) ) {
				ruolo = "ADMIN";
				break;
			}
		}
    	
        UserDetails utente = User.withUsername(autoUtente.getUsername())
        		.password(passwordEncoder().encode( autoUtente.getPassword() ))
        		.roles(ruolo).build();
        System.out.println(utente.getUsername()+" "+utente.getPassword()+" "+ruolo.toString());
        return new InMemoryUserDetailsManager(utente);
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
