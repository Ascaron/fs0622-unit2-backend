package com.epicode.andreacursi.controlloincendi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;
import com.epicode.andreacursi.controlloincendi.observer.IncendioObserver;

public class IncendioSubjectTest {
	
	IncendioObserver obs1;
	IncendioObserver obs2;
	IncendioObserver obs3;
	List<IncendioObserver> incObs;
	Sonda son;
	Incendio inc;

	
	@Before
	public void setUp() {
		incObs = new ArrayList<>();
		son=new Sonda(1, 100, 100);
		inc=new Incendio(1, son, 6);
	}
	
	@Test
	public void testAggiungiOsservatore() { 
		incObs.add(obs1);
		assertEquals(1, incObs.size());
	}

	@Test
	public void testRimuoviOsservatore() {
		incObs.add(obs2);
		incObs.add(obs3);
		assertEquals(2, incObs.size());
		incObs.remove(0);
		assertEquals(1, incObs.size());
	}

	@Test
	public void testSegnalaIncendi() {
		assertTrue(inc.getQuantitaFumo()>5);
	}
}
