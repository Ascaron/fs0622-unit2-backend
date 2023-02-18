package com.epicode.andreacursi.gestioneprenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.gestioneprenotazioni.model.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE codice = :valore"
		)
		List<Postazione> findByCodice(@Param("valore") String valore);
	
}
