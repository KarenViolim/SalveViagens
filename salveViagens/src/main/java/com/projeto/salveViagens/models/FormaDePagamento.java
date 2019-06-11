package com.projeto.salveViagens.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormaDePagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String formaPagamento;
	@ManyToOne
	private Cliente cliente;
	public long getIdFormaPagamento() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
