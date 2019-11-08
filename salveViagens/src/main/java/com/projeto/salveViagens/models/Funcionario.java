package com.projeto.salveViagens.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double salario;
	@ManyToOne
	private Papeis papeis;
	private String email;
	private String senha;
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Papeis getPapeis() {
		return papeis;
	}
	public void setPapeis(Papeis papeis) {
		this.papeis = papeis;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
