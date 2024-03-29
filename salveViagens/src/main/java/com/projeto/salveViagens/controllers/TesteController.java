package com.projeto.salveViagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Estado;
import com.projeto.salveViagens.repository.EstadoRepository;

@Controller
public class TesteController {
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/listaTeste")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/teste");
		List<Estado> estado = repository.findAll();
		mv.addObject("estado", estado);
		return mv;
	}
}
