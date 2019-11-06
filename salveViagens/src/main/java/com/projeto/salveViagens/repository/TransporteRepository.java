package com.projeto.salveViagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.salveViagens.models.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Long>{
	
	@Query("SELECT t FROM Transporte t WHERE t.id = ?1")
	Transporte buscarPorId(long id);

}
