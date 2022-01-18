package com.ibe.ibe.repositories;

import com.ibe.ibe.models.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VisitanteRepository extends JpaRepository<Visitante, Integer> {
}

