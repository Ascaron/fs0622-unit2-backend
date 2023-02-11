package com.andreacursi.godsfatherpizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.godsfatherpizza.entity.Toppings;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM toppings WHERE name = :valore"
		)
		List<Toppings> findByName(@Param("valore") String valore);
	
}
