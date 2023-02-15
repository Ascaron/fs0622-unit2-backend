package com.epicode.andreacursi.gestioneprenotazioni;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GestionePrenotazioniTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate tr;
	
	@Test
	public void controllo() {
		assertThat(
			tr.getForObject("http://localhost:" + port + "/saluto", String.class)
			.contains("poldo")
		);
	}
	
}
