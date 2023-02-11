package com.andreacursi.godsfatherpizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.godsfatherpizza.entity.Pizza;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository piRepo;
	
	public void insert(Pizza p) {
		piRepo.save(p);
	}
	
}
