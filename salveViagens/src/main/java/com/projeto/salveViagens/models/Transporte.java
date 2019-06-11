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
	private long id;
	private String valorTransporte;
	private Date dataPartida;
	private String nome;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
