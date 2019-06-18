package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Viagem;
import com.projeto.salveViagens.repository.ViagemRepository;



@Controller

public class ViagemController {
	@Autowired
	private ViagemRepository repositoryViagem;
	
	@Autowired
	public ViagemRepository repositoryCidade;
	
	@GetMapping("/listarViagem")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/viagem");
		mv.addObject("viagem", repositoryViagem.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarViagem")
	public ModelAndView add(Viagem viagem) {
		ModelAndView mv = new ModelAndView("/addviagem");
		mv.addObject("viagem", viagem);
		mv.addObject("cidades", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("/editarViagem/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Viagem> op = repositoryViagem.findById(id);
		Viagem via = op.get();
		return add(via);
	}
	
	@GetMapping("/removerViagem/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Viagem> op = repositoryViagem.findById(id);
		Viagem via = op.get();
		repositoryViagem.delete(via);
		return listar();
	}
	
	@PostMapping("/salvarViagem")
	public ModelAndView salvar(Viagem viagem) {
		repositoryViagem.save(viagem);
		return listar();
	}
}

