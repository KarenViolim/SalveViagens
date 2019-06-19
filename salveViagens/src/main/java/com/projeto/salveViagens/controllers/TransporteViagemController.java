package com.projeto.salveViagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.TransporteViagem;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.TransporteRepository;
import com.projeto.salveViagens.repository.TransporteViagemRepository;
import com.projeto.salveViagens.repository.ViagemRepository;


@Controller
public class TransporteViagemController {
	@Autowired
	private TransporteViagemRepository repository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private TransporteRepository transporteRepository;
	
	
	@GetMapping("/adicionarTransViagem")
	public ModelAndView add(TransporteViagem transporteViagem) {
		ModelAndView mv = new ModelAndView("/addtransporteviagem");
		mv.addObject("transporteViagem", transporteViagem);
		mv.addObject("viagem", viagemRepository.findAll());
		mv.addObject("cidade", cidadeRepository.findAll());
		mv.addObject("transporte", transporteRepository.findAll());
		return mv;
	}
	@GetMapping("/listaTransViagem")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/transporteviagem");
		mv.addObject("transporteViagem", repository.findAll());
		return mv;
	}
	

}
