package com.andreacursi.godsfatherpizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.godsfatherpizza.entity.Tavolo;

@Repository
public interface TableRepository extends JpaRepository<Tavolo, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM tavolo WHERE name = :valore"
		)
		List<Tavolo> findByName(@Param("valore") String valore);
	
}
