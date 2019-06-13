package com.projeto.salveViagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Cidade;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.EstadoRepository;

@Controller
public class CidadeController {
	
	@Autowired
	private CidadeRepository repositoryCidade;
	
	@Autowired
	public EstadoRepository repositoryEstado;
	
	@GetMapping("/listarCidade")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/cidade");
		mv.addObject("estados", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarCidade")
	public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView("/addcidade");
		mv.addObject("cidade", cidade);
		mv.addObject("estados", repositoryEstado.findAll());
		return mv;
	}
	
	
	@PostMapping("/salvarCidade")
	public ModelAndView salvar(Cidade cidade) {
		repositoryCidade.save(cidade);
		return listar();
	}

}
