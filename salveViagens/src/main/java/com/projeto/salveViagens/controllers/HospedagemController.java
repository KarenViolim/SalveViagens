package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Hospedagem;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.HospedagemRepository;



@Controller
public class HospedagemController {
	@Autowired
	private HospedagemRepository repositoryHospedagem;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@GetMapping("administrativo/hospedagem/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/hospedagem/lista");
		mv.addObject("hospedagem", repositoryHospedagem.findAll());
		return mv;
	}
	
	@GetMapping("administrativo/hospedagem/cadastrar")
	public ModelAndView add(Hospedagem hospedagem) {
		ModelAndView mv = new ModelAndView("/administrativo/hospedagem/cadastro");
		mv.addObject("hospedagem", hospedagem);
		mv.addObject("cidades", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("administrativo/hospedagem/editarHospedagem/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Hospedagem> op = repositoryHospedagem.findById(id);
		Hospedagem hos = op.get();
		return add(hos);
	}
	
	@GetMapping("administrativo/hospedagem/removerHospedagem/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Hospedagem> op = repositoryHospedagem.findById(id);
		Hospedagem hos = op.get();
		repositoryHospedagem.delete(hos);
		return listar();
	}
	
	@PostMapping("administrativo/hospedagem/salvarHospedagem")
	public ModelAndView salvar(Hospedagem hospedagem) {
		repositoryHospedagem.save(hospedagem);
		return listar();
	}
}