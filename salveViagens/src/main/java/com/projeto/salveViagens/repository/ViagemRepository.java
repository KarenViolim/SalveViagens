package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salveViagens.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{

}
