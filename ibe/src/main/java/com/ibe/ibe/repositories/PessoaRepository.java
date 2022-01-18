package com.ibe.ibe.repositories;

import com.ibe.ibe.models.Pessoa;
import com.ibe.ibe.models.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}

