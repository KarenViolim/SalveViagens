package com.projeto.salveViagens.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hospedagem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nomeHopedagem;
	private Double valorTotal;
	private Double valorDiaria;
	@ManyToOne
	private Cidade cidade;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeHopedagem() {
		return nomeHopedagem;
	}
	public void setNomeHopedagem(String nomeHopedagem) {
		this.nomeHopedagem = nomeHopedagem;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}