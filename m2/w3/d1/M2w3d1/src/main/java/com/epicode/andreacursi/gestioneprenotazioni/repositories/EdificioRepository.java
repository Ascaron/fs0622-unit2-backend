package com.epicode.andreacursi.gestioneprenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.gestioneprenotazioni.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer>{

}
