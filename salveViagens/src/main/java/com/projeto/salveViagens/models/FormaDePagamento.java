package com.projeto.salveViagens.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class FormaDePagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, length=70)
	
	@NotEmpty(message="A Forma de Pagamento é obrigatório")
	private String formaPagamento;
	
	private int parcela;

	public int getParcela() {
		return parcela;
	}
	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	public long getId() {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
