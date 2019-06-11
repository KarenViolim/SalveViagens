package com.projeto.salveViagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projeto.salveViagens.repository.EstadoRepository;

@Controller
public class EstadoController {
	@Autowired
	public EstadoRepository repository;

}
