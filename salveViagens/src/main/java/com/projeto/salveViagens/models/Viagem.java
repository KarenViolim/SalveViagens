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
	private Integer totalPassageiros;
	private Double comissao;
	private Date dataPartida;
	private Date dataRetorno;
	@ManyToOne
	private Funcionario funcionario;
	@ManyToOne
	private FormaDePagamento formaPagamento;
	@ManyToOne
	private Cliente cliente;
	private long transporte;
	private long hospedagem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getTotalPassageiros() {
		return totalPassageiros;
	}
	public void setTotalPassageiros(Integer totalPassageiros) {
		this.totalPassageiros = totalPassageiros;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
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
	public long getTransporte() {
		return transporte;
	}
	public void setTransporte(long transporte) {
		this.transporte = transporte;
	}
	public long getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(long hospedagem) {
		this.hospedagem = hospedagem;
	}
	
}
