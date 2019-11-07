package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.PermissoesFuncionario;
import com.projeto.salveViagens.repository.FuncionarioRepository;
import com.projeto.salveViagens.repository.PapeisRepository;
import com.projeto.salveViagens.repository.PermissoesFuncionarioRepository;

@Controller
public class PermissoesController {
	
	@Autowired
	private PermissoesFuncionarioRepository repositoryPermissoes;
	
	@Autowired
	private PapeisRepository repositoryPapeis;
	
	@Autowired
	public FuncionarioRepository repositoryFuncionario;
	
	@GetMapping("administrativo/permissao/cadastrar")
	public ModelAndView add(PermissoesFuncionario permissoes) {
		ModelAndView mv = new ModelAndView("/administrativo/permissao/cadastro");
		mv.addObject("permissoes", permissoes);
		mv.addObject("funcionarios", repositoryFuncionario.findAll());
		mv.addObject("papeis", repositoryPapeis.findAll());
		return mv;
	}
	
	@GetMapping("administrativo/permissao/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/permissao/lista");
		mv.addObject("permissoes", repositoryPermissoes.findAll());
		return mv;
	}
	
	
	@GetMapping("administrativo/permissao/editarPermissao/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<PermissoesFuncionario> op = repositoryPermissoes.findById(id);
		PermissoesFuncionario p = op.get();
		return add(p);
	}
	
	@GetMapping("administrativo/permissao/removerPermissao/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<PermissoesFuncionario> op = repositoryPermissoes.findById(id);
		PermissoesFuncionario p = op.get();
		repositoryPermissoes.delete(p);
		return listar();
	}
	
	@PostMapping("administrativo/permissao/salvarPermissao")
	public ModelAndView salvar(PermissoesFuncionario permissoes) {
		repositoryPermissoes.save(permissoes);
		return listar();
	}
	

}
