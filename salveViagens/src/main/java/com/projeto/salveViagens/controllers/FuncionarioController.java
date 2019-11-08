package com.projeto.salveViagens.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Funcionario;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.FuncionarioRepository;
import com.projeto.salveViagens.repository.PapeisRepository;
@Controller
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository repositoryFuncionario;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@Autowired
	public PapeisRepository repositoryPapeis;
	
	@GetMapping("administrativo/funcionario/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/funcionario/lista");
		mv.addObject("funcionario", repositoryFuncionario.findAll());
		return mv;
	}
	
	@GetMapping("administrativo/funcionario/cadastrar")
	public ModelAndView add(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("/administrativo/funcionario/cadastro");
		mv.addObject("funcionario", funcionario);
		mv.addObject("cidades", repositoryCidade.findAll());
		mv.addObject("papeis", repositoryPapeis.findAll());

		return mv;
	}
	
	@GetMapping("administrativo/funcionario/editarFuncionario/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Funcionario> op = repositoryFuncionario.findById(id);
		Funcionario func = op.get();
		return add(func);
	}
	
	@GetMapping("administrativo/funcionario/removerFuncionario/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Funcionario> op = repositoryFuncionario.findById(id);
		Funcionario func = op.get();
		repositoryFuncionario.delete(func);
		return listar();
	}
	
	@PostMapping("administrativo/funcionario/salvarFuncionario")
	public ModelAndView salvar(Funcionario funcionario) {
		funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
		
		repositoryFuncionario.save(funcionario);
		return listar();
	}

}
