package com.projeto.salveViagens.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Viagem { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idViagem;
	private Integer quantPessoas;
	private Double comissao;
	private Double valorTotal;
	private Date dataViagem;
	@ManyToOne
	private Funcionario funcionario;
	@ManyToOne
	private FormaDePagamento formaPagamento;
	@ManyToMany
	private List<Cliente> clientes;
	public long getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(long idViagem) {
		this.idViagem = idViagem;
	}
	public Integer getQuantPessoas() {
		return quantPessoas;
	}
	public void setQuantPessoas(Integer quantPessoas) {
		this.quantPessoas = quantPessoas;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
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
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
