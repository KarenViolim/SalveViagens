package com.projeto.salveViagens.controllers;

import java.util.Calendar;
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
import com.projeto.salveViagens.models.Companhia;
import com.projeto.salveViagens.models.Transporte;
import com.projeto.salveViagens.models.Viagem;
import com.projeto.salveViagens.repository.CidadeRepository;
import com.projeto.salveViagens.repository.ClienteRepository;
import com.projeto.salveViagens.repository.CompanhiaRepository;
import com.projeto.salveViagens.repository.FormaPagamentoRepository;
import com.projeto.salveViagens.repository.FuncionarioRepository;
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
	
	@Autowired
	private FormaPagamentoRepository repositorioForma;
	
	@Autowired
	private ClienteRepository repositorioCliente;
	
	@Autowired
	private FuncionarioRepository repositorioFuncionario;
	
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
		ModelAndView mv = new ModelAndView("/teste");
		mv.addObject("viagens", repositoryViagem.findAll());
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
				viagem.setTransporte(transporte);
			}
			Calendar a = Calendar.getInstance();
			a.setTime(viagem.getDataRetorno());//data maior

			Calendar b = Calendar.getInstance();
			b.setTime(viagem.getDataPartida());// data menor

			a.add(Calendar.DATE, - b.get(Calendar.DAY_OF_MONTH));
			viagem.setDiarias(a.get(Calendar.DAY_OF_MONTH));
		}
		repositoryViagem.save(viagem);
		
		return hotel(viagem);
	}
	
	@PostMapping("/listarHotel")
	public ModelAndView hotel(Viagem viagem) {
		ModelAndView mv = new ModelAndView("/hoteis");
		mv.addObject("hoteis", repositorioHotel.buscarPorDestino(viagem.getTransporte().getDestino()));
		mv.addObject("viagem", viagem);
		return mv;
	}
	
	@PostMapping("/hotelViagem")
	public ModelAndView salvar(@Valid Viagem viagem) {
		Optional<Viagem> op = repositoryViagem.findById(viagem.getId());
		Viagem via = op.get();
		via.setHospedagem(viagem.getHospedagem());
	
		via.setTotal((via.getHospedagem().getValor() * via.getDiarias() * via.getTotalPassageiros()) + (via.getTransporte().getValorPassagem() * via.getTotalPassageiros()));
		via.setComissao(via.getTotal()*0.02);
		via.setCustoTotal((via.getHospedagem().getCustoHospedagem() * via.getDiarias() * via.getTotalPassageiros()) + (via.getTransporte().getCustoPassagem() * via.getTotalPassageiros()) + via.getComissao());
		repositoryViagem.save(via);
		return resumo(via);
	}
	
	@PostMapping("/listarResumo")
	public ModelAndView resumo(Viagem viagem) {
		ModelAndView mv = new ModelAndView("/services");
		mv.addObject("formas", repositorioForma.findAll());
		mv.addObject("clientes", repositorioCliente.findAll());
		mv.addObject("funcionarios", repositorioFuncionario.findAll());
		mv.addObject("viagem", viagem);
		return mv;
	}
	
	@PostMapping("/pagamento")
	public ModelAndView pagamento(@Valid Viagem viagem) {
		Optional<Viagem> op = repositoryViagem.findById(viagem.getId());
		Viagem via = op.get();
		via.setFormaPagamento(viagem.getFormaPagamento());
		via.setCliente(viagem.getCliente());
		via.setFuncionario(viagem.getFuncionario());
		repositoryViagem.save(via);
		return fim();
	}
	
	@PostMapping("/fim")
	public ModelAndView fim() {
		ModelAndView mv = new ModelAndView("/final");
		mv.addObject("viagens", repositoryViagem.findAll());
		return mv;
	} 
	
	
}

