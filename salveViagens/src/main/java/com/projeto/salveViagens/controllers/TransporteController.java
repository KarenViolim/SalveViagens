package com.projeto.salveViagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Transporte;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.CompanhiaRepository;
import com.projeto.salveViagens.repository.TransporteRepository;

@Controller
public class TransporteController {
	@Autowired
	private TransporteRepository repository;
	
	@Autowired
	private CidadeRepository repositoryCidade;
	@Autowired
	private CompanhiaRepository repositoryCompanhia;
	
	@GetMapping("administrativo/transporte/cadastrar")
	public ModelAndView add(Transporte transporte) {
		ModelAndView mv = new ModelAndView("/administrativo/transporte/cadastro");
		mv.addObject("transporte",transporte);
		mv.addObject("cidade", repositoryCidade.findAll());
		mv.addObject("companhia", repositoryCompanhia.findAll());
		return mv;
	}
	@GetMapping("administrativo/transporte/listar")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/administrativo/transporte/lista");
		List<Transporte> transporte = repository.findAll();
		mv.addObject("transporte", transporte);
		return mv;
	}
	@GetMapping("administrativo/transporte/editarTransporte/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Transporte> transporte = repository.findById(id);
		Transporte transp = transporte.get();
		return add(transp);
	}
	@GetMapping("administrativo/transporte/removerTransporte/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Transporte> transporte = repository.findById(id);
		Transporte transp = transporte.get();
		repository.delete(transp);
		return lista();
	}
	@PostMapping("administrativo/transporte/salvarTransporte")
	public ModelAndView salvar(@Valid Transporte transporte, BindingResult result) {
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(transporte);
		return lista();
	}	
}
