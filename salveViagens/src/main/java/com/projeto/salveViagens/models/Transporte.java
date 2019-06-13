package com.projeto.salveViagens.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transporte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
