package com.epicode.andreacursi.controlloincendi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;

@Repository
public interface IncendioRepository extends JpaRepository<Incendio, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM segnalazione WHERE sonda_id = :valore"
		)
		List<Incendio> findBySondaId(@Param("valore") Integer valore);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM segnalazione WHERE quantita_fumo = :valore"
		)
		List<Incendio> findByFumo(@Param("valore") Integer valore);
	
}
