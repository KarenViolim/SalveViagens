package com.projeto.salveViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.salveViagens.models.FormaDePagamento;


public interface FormaPagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

}