package com.andreacursi.gestioneprenotazioni.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andreacursi.gestioneprenotazioni.entity.Prenotazioni;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prenotazioni WHERE data_prenotazione = :valore"
		)
		List<Prenotazioni> findByDataPrenotazione(@Param("valore") LocalDate valore);	

}
