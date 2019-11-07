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

import com.projeto.salveViagens.models.Papeis;
import com.projeto.salveViagens.repository.PapeisRepository;

@Controller
public class PapeisController {
	@Autowired
	public PapeisRepository repositoryPapeis;
	
	@GetMapping("/administrativo/papel/cadastrar")
	public ModelAndView add(Papeis papeis) {
		ModelAndView mv = new ModelAndView("/administrativo/papel/cadastro");
		mv.addObject("papeis", papeis);
		return mv;
	}
	
	@GetMapping("/administrativo/papel/listar")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/administrativo/papel/lista");
		List<Papeis> papeis = repositoryPapeis.findAll();
		mv.addObject("papeis", papeis);
		return mv;
	}
	
	@GetMapping("/administrativo/papel/editarPapel/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Papeis> papeis = repositoryPapeis.findById(id);
		Papeis p = papeis.get();
		return add(p);
		
	}
	@GetMapping("/administrativo/papel/removerPapel/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Papeis> papeis = repositoryPapeis.findById(id);
		Papeis p = papeis.get();
		repositoryPapeis.delete(p);
		return lista();
		
	}
	
	@PostMapping("/administrativo/papel/salvarPapel")
	public ModelAndView salvar(@Valid Papeis papeis, BindingResult result ) {
		if(result.hasErrors()) {
			return add(papeis);
		}
		repositoryPapeis.saveAndFlush(papeis);
		return lista();
	}

}
