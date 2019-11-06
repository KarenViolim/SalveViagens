package com.projeto.salveViagens.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transporte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Double valorPassagem;
	@ManyToOne
	private Cidade origem;
	@ManyToOne
	private Cidade destino;
	@ManyToOne
	private Companhia companhia;
	
	public Companhia getCompanhia() {
		return companhia;
	}
	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getValorPassagem() {
		return valorPassagem;
	}
	public void setValorPassagem(Double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	
}
