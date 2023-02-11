package com.andreacursi.godsfatherpizza.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.godsfatherpizza.entity.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM franchise WHERE name = :valore"
		)
		List<Franchise> findByName(@Param("valore") String valore);
	
}
