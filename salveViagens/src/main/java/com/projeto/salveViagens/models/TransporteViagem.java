package com.projeto.salveViagens.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TransporteViagem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Viagem idviagem;
	@ManyToOne
	private TransporteViagem idtransporte;
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
	public Viagem getIdviagem() {
		return idviagem;
	}
	public void setIdviagem(Viagem idviagem) {
		this.idviagem = idviagem;
	}
	public TransporteViagem getIdtransporte() {
		return idtransporte;
	}
	public void setIdtransporte(TransporteViagem idtransporte) {
		this.idtransporte = idtransporte;
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
