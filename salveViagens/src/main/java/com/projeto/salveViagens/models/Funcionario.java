package com.projeto.salveViagens.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;


@Entity
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double salario;
	private Date dataInicio;
	@Column(nullable=false, length=50)
	@NotEmpty(message="O Cargo é obrigatório")
	private String cargo;
	
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
