package com.andreacursi.godsfatherpizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.godsfatherpizza.entity.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM pizza WHERE name = :valore"
		)
		List<Pizza> findByName(@Param("valore") String valore);
	
}
