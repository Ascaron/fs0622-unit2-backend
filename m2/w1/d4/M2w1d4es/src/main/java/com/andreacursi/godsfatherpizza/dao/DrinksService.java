package com.andreacursi.godsfatherpizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.godsfatherpizza.entity.Drinks;
import com.andreacursi.godsfatherpizza.entity.Franchise;
import com.andreacursi.godsfatherpizza.entity.Pizza;
import com.andreacursi.godsfatherpizza.entity.Tavolo;
import com.andreacursi.godsfatherpizza.entity.Toppings;

@Service
public class DrinksService {

	@Autowired
	private DrinksRepository driRepo;
	
	public void insert(Drinks d) {
		driRepo.save(d);
	}
	
//	@Autowired
//	private FranchiseRepository fraRepo;
//	
//	public void insert(Franchise f) {
//		fraRepo.save(f);
//	}
//	
//	@Autowired
//	private PizzaRepository piRepo;
//	
//	public void insert(Pizza p) {
//		piRepo.save(p);
//	}
//	
//	@Autowired
//	private TableRepository taRepo;
//	
//	public void insert(Tavolo t) {
//		taRepo.save(t);
//	}
//	
//	@Autowired
//	private ToppingsRepository topRepo;
//	
//	public void insert(Toppings t) {
//		topRepo.save(t);
//	}
	
}
