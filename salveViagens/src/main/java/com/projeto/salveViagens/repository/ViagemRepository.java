package com.projeto.salveViagens.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.salveViagens.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{

	@Query("SELECT t FROM Viagem t WHERE t.id = ?1")
	Viagem buscarTotal(long id);
	
	@Query("SELECT sum(v.total) FROM Viagem v WHERE v.funcionario.id = ?1 GROUP by v.funcionario")
	int relatorioFuncionario(long funcionario);
	
	@Query("SELECT v FROM Viagem v WHERE v.dataPartida BETWEEN ?1 and ?2")
	List<Viagem> relatorioLucro(Date inicio, Date fim);
}
