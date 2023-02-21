package com.epicode.andreacursi.gestioneprenotazioni.configuration;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.entities.Utente;
import com.epicode.andreacursi.gestioneprenotazioni.services.UserDetailsImplService;
import com.epicode.andreacursi.gestioneprenotazioni.services.UtenteService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UtenteService uteSe;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()					
				.antMatchers( "/", "/page1", "/page2", "/edifici/{id}").permitAll()
			.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.successForwardUrl("/login_success")
			.and()
			.logout()
			.and()
			.csrf()
				.disable();
	}
	
	@Autowired
	private UserDetailsImplService useDeSe;
	
	// v2 get from db
	
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		Optional<Utente> authUserObj = uteSe.ottieniDaId(1);
//		Utente authUser = authUserObj.get();
//		String ruolo = "USER";
//		Set<Ruolo> ruoli = authUser.getRuolo();
//		
//		for( Ruolo r : ruoli ) {
//			if( r.getTipo().toString().contains("ADMIN") ) {
//				ruolo = "ADMIN";
//				break;
//			}
//		}
//		
//		auth.inMemoryAuthentication()
//			.withUser( authUser.getUsername() ).password( passwordEncoder().encode( authUser.getPassword() ) )
//			.roles(ruolo);
//	}
	
	// v2 bd con userdetailsimpl
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.userDetailsService(useDeSe)
//			.passwordEncoder( passwordEncoder() );
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
}
