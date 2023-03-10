package com.epicode.andreacursi.chiamato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.chiamato.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
