package com.projeto.salveViagens.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TransporteViagem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Viagem viagem;
	@ManyToOne
	private TransporteViagem transporte;
	@ManyToOne
	private Cidade origem;
	@ManyToOne
	private Cidade destino;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Viagem getViagem() {
		return viagem;
	}
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
	public TransporteViagem getTransporte() {
		return transporte;
	}
	public void setTransporte(TransporteViagem transporte) {
		this.transporte = transporte;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
