package com.andreacursi.gestioneprenotazioni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.gestioneprenotazioni.entity.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE codice = :valore"
		)
		List<Postazione> findByCodice(@Param("valore") String valore);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE tipo = :valore"
		)
		List<Postazione> findByTipo(@Param("valore") String valore);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE edificio_id = :valore"
		)
		List<Postazione> cercaDaEdificioId(@Param("valore") Integer valore);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE id = :valore"
		)
		List<Postazione> cercaDaId(@Param("valore") Integer valore);
	
}
