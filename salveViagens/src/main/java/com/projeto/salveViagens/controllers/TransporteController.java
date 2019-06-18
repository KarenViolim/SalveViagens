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
import com.projeto.salveViagens.repository.TransporteRepository;

@Controller
public class TransporteController {
	@Autowired
	private TransporteRepository repository;
	
	@GetMapping("/adcionarTransporte")
	public ModelAndView add(Transporte transporte) {
		ModelAndView mv = new ModelAndView("/addTransporte");
		mv.addObject("transporte",transporte);
		return mv;
	}
	@GetMapping("/listaTransporte")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/listaTransporte");
		List<Transporte> transporte = repository.findAll();
		mv.addObject("transporte", transporte);
		return mv;
	}
	@GetMapping("/editarTransporte/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Transporte> transporte = repository.findById(id);
		Transporte transp = transporte.get();
		return add(transp);
	}
	@GetMapping("/removerTransporte/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Transporte> transporte = repository.findById(id);
		Transporte transp = transporte.get();
		repository.delete(transp);
		return lista();
	}
	@PostMapping("/salvarTransporte")
	public ModelAndView salvar(@Valid Transporte transporte, BindingResult result) {
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(transporte);
		return lista();
	}
	
	
	
}
