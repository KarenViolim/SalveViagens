package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Companhia;
import com.projeto.salveViagens.repository.CompanhiaRepository;

@Controller
public class CompanhiaController {
	
	@Autowired
	public CompanhiaRepository repositoryCompanhia;
	
	@GetMapping("administrativo/companhia/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/companhia/lista");
		mv.addObject("companhia", repositoryCompanhia.findAll());
		return mv;
	}
	
	@GetMapping("administrativo/companhia/cadastrar")
	public ModelAndView add(Companhia companhia) {
		ModelAndView mv = new ModelAndView("/administrativo/companhia/cadastro");
		mv.addObject("companhia", companhia);
		return mv;
	}
	
	@GetMapping("administrativo/companhia/editarCompanhia/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Companhia> op = repositoryCompanhia.findById(id);
		Companhia cli = op.get();
		return add(cli);
	}
	
	@GetMapping("administrativo/companhia/removerCompanhia/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Companhia> op = repositoryCompanhia.findById(id);
		Companhia cli = op.get();
		repositoryCompanhia.delete(cli);
		return listar();
	}
	
	@PostMapping("administrativo/companhia/salvarCompanhia")
	public ModelAndView salvar(Companhia companhia) {
		repositoryCompanhia.save(companhia);
		return listar();
	}
}
