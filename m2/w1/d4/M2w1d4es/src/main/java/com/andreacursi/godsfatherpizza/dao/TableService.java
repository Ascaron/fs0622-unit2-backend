package com.andreacursi.godsfatherpizza.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreacursi.godsfatherpizza.entity.Tavolo;

@Service
public class TableService {

	@Autowired
	private TableRepository taRepo;
	
	public void insert(Tavolo t) {
		taRepo.save(t);
	}
	
}
