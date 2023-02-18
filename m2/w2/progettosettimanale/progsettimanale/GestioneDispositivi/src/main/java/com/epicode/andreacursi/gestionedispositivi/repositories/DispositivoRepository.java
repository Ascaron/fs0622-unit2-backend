package com.epicode.andreacursi.gestionedispositivi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.gestionedispositivi.entities.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM dispositivo WHERE tipo = :valore"
		)
		List<Dispositivo> findByTipo(@Param("valore") String valore);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM dispositivo WHERE stato = :valore"
		)
		List<Dispositivo> findByStato(@Param("valore") String valore);
	
}
