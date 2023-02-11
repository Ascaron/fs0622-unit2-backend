package com.andreacursi.godsfatherpizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.godsfatherpizza.entity.Franchise;

@Service
public class FranchiseService {

	@Autowired
	private FranchiseRepository fraRepo;
	
	public void insert(Franchise f) {
		fraRepo.save(f);
	}
	
}
