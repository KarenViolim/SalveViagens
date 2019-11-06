package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.salveViagens.models.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem,Long>{
	
	@Query("SELECT t FROM Hospedagem t WHERE t.id = ?1")
	Hospedagem buscarPorId(long id);
	
}
