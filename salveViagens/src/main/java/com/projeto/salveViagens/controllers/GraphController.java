package com.projeto.salveViagens.controllers;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.salveViagens.models.Funcionario;
import com.projeto.salveViagens.models.Viagem;
import com.projeto.salveViagens.repository.FuncionarioRepository;
import com.projeto.salveViagens.repository.ViagemRepository;

@Controller
public class GraphController {
	
	@Autowired
	private ViagemRepository repositoryViagem;
	
	@Autowired
	private FuncionarioRepository repositorioFuncionario;
	
	@GetMapping("/relatorio")
	public String relatorio() {
		return "relatorio";
	}

	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		List<Funcionario> fun = repositorioFuncionario.findAll(); 
		for (Funcionario f : fun) {
			int viagem = repositoryViagem.relatorioFuncionario(f.getId());

			System.out.println((viagem));
			surveyMap.put(f.getNome(), viagem);
		}
		model.addAttribute("surveyMap", surveyMap);
		return "relatorioFuncionario";
	}

	@GetMapping("/lucro")
	public ModelAndView pieChart() {
		ModelAndView mv = new ModelAndView("relatorioLucro");
		List<Viagem> viagens = repositoryViagem.findAll();

		int total = 0;
		int custo = 0;
		for (Viagem v: viagens) {
			total += v.getTotal();
			custo += v.getCustoTotal();
		}
		mv.addObject("total", total);
		mv.addObject("custo", custo);
		return mv;
	}

}
