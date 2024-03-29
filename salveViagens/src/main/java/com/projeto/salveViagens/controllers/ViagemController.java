package com.projeto.salveViagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Cidade;
import com.projeto.salveViagens.models.Cliente;
import com.projeto.salveViagens.models.Companhia;
import com.projeto.salveViagens.models.Hospedagem;
import com.projeto.salveViagens.models.Transporte;
import com.projeto.salveViagens.models.Viagem;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.CompanhiaRepository;
import com.projeto.salveViagens.repository.HospedagemRepository;
import com.projeto.salveViagens.repository.TransporteRepository;
import com.projeto.salveViagens.repository.ViagemRepository;



@Controller

public class ViagemController {
	@Autowired
	private ViagemRepository repositoryViagem;

	@Autowired
	private CidadeRepository repositorioCidade;
	
	@Autowired
	private CompanhiaRepository repositorioCompanhia;
	
	@Autowired
	private TransporteRepository repositorioTransporte;
	
	@Autowired
	private HospedagemRepository repositorioHotel;
	
	@GetMapping("/")
	public ModelAndView add(Viagem viagem) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cidades", repositorioCidade.findAll());
		mv.addObject("companhias", repositorioCompanhia.findAll());
		mv.addObject("viagem", viagem);
		return mv;
	}
	
	@GetMapping("/listarViagem")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/viagem");
		mv.addObject("viagem", repositoryViagem.findAll());
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
	public ModelAndView salvar(@Valid Viagem viagem, @RequestParam Cidade origem, @RequestParam Cidade destino, @RequestParam Companhia companhia) {
		
		List<Transporte> t = repositorioTransporte.findAll();
		for (Transporte transporte : t) {
			if(
				transporte.getOrigem().getId() == origem.getId() &&
				transporte.getDestino().getId() == destino.getId() &&
				transporte.getCompanhia().getId() == companhia.getId()
			) {
				viagem.setTransporte(transporte.getId());
			}
		}
		repositoryViagem.save(viagem);
		
		return hotel(viagem, destino);
	}
	
	@PostMapping("/listarHotel")
	public ModelAndView hotel(Viagem viagem, Cidade destino) {
		ModelAndView mv = new ModelAndView("/hoteis");
		mv.addObject("hoteis", repositorioHotel.findAll());
		mv.addObject("viagem", viagem);
		return mv;
	}
	
	@PostMapping("/hotelViagem")
	public ModelAndView salvar(@Valid Viagem viagem, @RequestParam long hospedagem) {
		Optional<Viagem> op = repositoryViagem.findById(viagem.getId());
		Viagem via = op.get();
		via.setHospedagem(hospedagem);
		repositoryViagem.save(via);
		return resumo(via);
	}
	
	@PostMapping("/listarResumo")
	public ModelAndView resumo(Viagem viagem) {
		ModelAndView mv = new ModelAndView("/services");
		mv.addObject("transporte", repositorioTransporte.buscarPorId(viagem.getTransporte()));
		mv.addObject("hotel", repositorioHotel.buscarPorId(viagem.getHospedagem()));
		mv.addObject("viagem", viagem);
		return mv;
	}
}

