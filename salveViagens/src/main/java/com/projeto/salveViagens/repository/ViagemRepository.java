package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.salveViagens.models.Hospedagem;
import com.projeto.salveViagens.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{

	@Query("SELECT t FROM Viagem t WHERE t.id = ?1")
	Hospedagem buscarTotal(long id);
}
