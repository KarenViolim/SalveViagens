package com.projeto.salveViagens.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Viagem implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Integer TotalPassageiros;
	private Double comissao;
	private Double Total;
	private Date data;
	@ManyToOne
	private Funcionario funcionario;
	@ManyToOne
	private FormaDePagamento formaPagamento;
	@ManyToOne
	private Cliente cliente;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getTotalPassageiros() {
		return TotalPassageiros;
	}
	public void setTotalPassageiros(Integer totalPassageiros) {
		TotalPassageiros = totalPassageiros;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public FormaDePagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaDePagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
