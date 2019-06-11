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
	private long idTranporteViagem;
	@ManyToOne
	private Viagem idViagem;
	@ManyToOne
	private TransporteViagem idTransporte;
	@ManyToOne
	private Cidade origem;
	@ManyToOne
	private Cidade destino;
	public long getIdTranporteViagem() {
		return idTranporteViagem;
	}
	public void setIdTranporteViagem(long idTranporteViagem) {
		this.idTranporteViagem = idTranporteViagem;
	}
	public Viagem getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(Viagem idViagem) {
		this.idViagem = idViagem;
	}
	public TransporteViagem getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(TransporteViagem idTransporte) {
		this.idTransporte = idTransporte;
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
