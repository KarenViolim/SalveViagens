package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salveViagens.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

