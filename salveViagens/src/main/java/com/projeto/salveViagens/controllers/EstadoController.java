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

import com.projeto.salveViagens.models.Estado;
import com.projeto.salveViagens.repository.EstadoRepository;

@Controller
public class EstadoController {
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/administrativo/estado/listar")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/administrativo/estado/lista");
		List<Estado> estado = repository.findAll();
		mv.addObject("estado", estado);
		return mv;
	}
	
	@PostMapping("/administrativo/estado/buscarEstado")
	public ModelAndView pesquisar(String pesquisa) {
		ModelAndView mv = new ModelAndView("/administrativo/estado/lista");
		List<Estado> estado = repository.buscarPorNome(pesquisa);
		mv.addObject("estado", estado);
		return mv;
	}
	
	@GetMapping("/administrativo/estado/cadastrar")
	public ModelAndView add(Estado estado) {
		ModelAndView mv = new ModelAndView("/administrativo/estado/cadastro");
		mv.addObject("estado", estado);
		return mv;
	}
	@GetMapping("/administrativo/estado/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		return add(e);
		
	}
	@GetMapping("/administrativo/estado/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		repository.delete(e);
		return lista();
		
	}
	@PostMapping("/administrativo/estado/salvarEstado")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result ) {
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(estado);
		return lista();
	}

}
