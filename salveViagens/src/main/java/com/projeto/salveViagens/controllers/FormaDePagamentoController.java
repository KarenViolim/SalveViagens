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

import com.projeto.salveViagens.models.FormaDePagamento;
import com.projeto.salveViagens.repository.FormaPagamentoRepository;

@Controller
public class FormaDePagamentoController {
	@Autowired
	public FormaPagamentoRepository repository;
	
	@GetMapping("/listaFormaPagamento")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/formapg");
		List<FormaDePagamento> formadepagamento = repository.findAll();
		mv.addObject("formadepagamento", formadepagamento);
		return mv;
	}
	
	@GetMapping("/adicionarFormaPagamento")
	public ModelAndView add(FormaDePagamento formadepagamento) {
		ModelAndView mv = new ModelAndView("/addformapg");
		mv.addObject("formadepagamento", formadepagamento);
		return mv;
	}
	@GetMapping("/editarFormaPagamento/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<FormaDePagamento> formadepagamento = repository.findById(id);
		FormaDePagamento forma = formadepagamento.get();
		return add(forma);
		
	}
	@GetMapping("/removerFormaPagamento/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<FormaDePagamento> formadepagamento = repository.findById(id);
		FormaDePagamento forma = formadepagamento.get();
		repository.delete(forma);
		return lista();
		
	}
	@PostMapping("/salvarFormaPagamento")
	public ModelAndView salvar(@Valid FormaDePagamento formadepagamento, BindingResult result ) {
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(formadepagamento);
		return lista();
	}
}
