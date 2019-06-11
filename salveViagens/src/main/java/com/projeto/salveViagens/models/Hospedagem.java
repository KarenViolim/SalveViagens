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
	private long idHospedagem;
	private String nomeHopedagem;
	private Double valorTotalHopedagem;
	private Double valorDiaria;
	@ManyToOne
	private Cidade cidade;
	public long getIdHospedagem() {
		return idHospedagem;
	}
	public void setIdHospedagem(long idHospedagem) {
		this.idHospedagem = idHospedagem;
	}
	public String getNomeHopedagem() {
		return nomeHopedagem;
	}
	public void setNomeHopedagem(String nomeHopedagem) {
		this.nomeHopedagem = nomeHopedagem;
	}
	public Double getValorTotalHopedagem() {
		return valorTotalHopedagem;
	}
	public void setValorTotalHopedagem(Double valorTotalHopedagem) {
		this.valorTotalHopedagem = valorTotalHopedagem;
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
