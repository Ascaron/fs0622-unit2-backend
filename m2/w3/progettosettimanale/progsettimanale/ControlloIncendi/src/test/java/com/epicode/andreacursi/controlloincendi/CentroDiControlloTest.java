package com.epicode.andreacursi.controlloincendi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;
import com.epicode.andreacursi.controlloincendi.observer.CentroDiControllo;
import com.epicode.andreacursi.controlloincendi.services.SondaService;

public class CentroDiControlloTest {
	
	Incendio incendio;
	CentroDiControllo cdc;
	Sonda son;
	
	@Before
	public void setUp() {
		son=new Sonda(1,100, 100);
		incendio = new Incendio(1, son, 6);
		cdc=new CentroDiControllo();
	}
	
	@Test
	public void testSegnala() {
		assertEquals("alarm/?idsonda="+son.getId()+"&lat="+son.getLatitudine()
		+"&lon="+son.getLongitudine()+"&smokelevel="+incendio.getQuantitaFumo(), cdc.segnala(incendio));
	}

}
