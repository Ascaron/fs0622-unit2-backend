package com.epicode.andreacursi.controlloincendi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.controlloincendi.entities.Sonda;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Integer>{

}
