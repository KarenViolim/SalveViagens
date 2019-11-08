package com.projeto.salveViagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.salveViagens.models.Cidade;
import com.projeto.salveViagens.models.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem,Long>{
	
	@Query("SELECT t FROM Hospedagem t WHERE t.id = ?1")
	Hospedagem buscarPorId(long id);
	
	@Query("SELECT t FROM Hospedagem t WHERE t.cidade = ?1")
	List<Hospedagem> buscarPorDestino(Cidade id);
}
