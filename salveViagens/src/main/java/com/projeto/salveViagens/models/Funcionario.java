package com.projeto.salveViagens.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFuncionario;
	private String nomeFuncionario;
	private String telefone;
	private Double salario;
	private Date dataInicio;
	private String cargo;
	public long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
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
	
}
