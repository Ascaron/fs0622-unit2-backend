package com.andreacursi.godsfatherpizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.godsfatherpizza.entity.Toppings;

@Service
public class ToppingsService {

	@Autowired
	private ToppingsRepository topRepo;
	
	public void insert(Toppings t) {
		topRepo.save(t);
	}
	
}
