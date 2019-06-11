package com.projeto.salveViagens.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transporte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTransporte;
	private String valorTransporte;
	private Date dataPartida;
	private String nomeTransporte;
	public long getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}
	public String getValorTransporte() {
		return valorTransporte;
	}
	public void setValorTransporte(String valorTransporte) {
		this.valorTransporte = valorTransporte;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public String getNomeTransporte() {
		return nomeTransporte;
	}
	public void setNomeTransporte(String nomeTransporte) {
		this.nomeTransporte = nomeTransporte;
	}
	
}
