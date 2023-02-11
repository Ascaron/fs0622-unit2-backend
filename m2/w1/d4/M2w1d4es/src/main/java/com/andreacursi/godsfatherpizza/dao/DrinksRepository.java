package com.andreacursi.godsfatherpizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.godsfatherpizza.entity.Drinks;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM drinks WHERE name = :valore"
		)
		List<Drinks> findByName(@Param("valore") String valore);
	
}
