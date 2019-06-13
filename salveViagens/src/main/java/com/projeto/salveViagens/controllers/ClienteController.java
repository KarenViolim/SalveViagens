package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Cliente;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@GetMapping("/listarCliente")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/cliente");
		mv.addObject("cliente", repositoryCliente.findAll());
		return mv;
	}
	
	@GetMapping("/adicionarCliente")
	public ModelAndView add(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/addcliente");
		mv.addObject("cliente", cliente);
		mv.addObject("cidades", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Cliente> op = repositoryCliente.findById(id);
		Cliente cli = op.get();
		return add(cli);
	}
	
	@GetMapping("/removerCliente/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Cliente> op = repositoryCliente.findById(id);
		Cliente cli = op.get();
		repositoryCliente.delete(cli);
		return listar();
	}
	
	@PostMapping("/salvarCliente")
	public ModelAndView salvar(Cliente cliente) {
		repositoryCliente.save(cliente);
		return listar();
	}
}
