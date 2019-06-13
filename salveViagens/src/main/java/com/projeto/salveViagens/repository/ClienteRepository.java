package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salveViagens.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

