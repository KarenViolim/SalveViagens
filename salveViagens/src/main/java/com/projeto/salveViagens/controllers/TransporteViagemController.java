package com.projeto.salveViagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.TransporteRepository;
import com.projeto.salveViagens.repository.ViagemRepository;



@Controller
public class TransporteViagemController {
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private TransporteRepository transporteRepository;
	

}
