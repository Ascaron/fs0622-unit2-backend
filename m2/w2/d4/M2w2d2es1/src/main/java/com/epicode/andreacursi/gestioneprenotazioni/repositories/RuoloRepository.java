package com.epicode.andreacursi.gestioneprenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.gestioneprenotazioni.model.Ruolo;
import com.epicode.andreacursi.gestioneprenotazioni.model.TipoDiRuolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Integer>{

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM ruolo WHERE tipo = :valore"
		)
		List<Ruolo> findByTipologia(@Param("valore") TipoDiRuolo valore);
	
}
