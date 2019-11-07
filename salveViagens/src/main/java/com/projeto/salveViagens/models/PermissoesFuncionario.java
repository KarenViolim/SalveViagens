package com.projeto.salveViagens.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="permissoes_funcionario")
public class PermissoesFuncionario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Funcionario funcionario;
	@ManyToOne
	private Papeis papeis;
	private Date dataPermissao;
	public Date getDataPermissao() {
		return dataPermissao;
	}
	public void setDataPermissao(Date dataPermissao) {
		this.dataPermissao = dataPermissao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Papeis getPapeis() {
		return papeis;
	}
	public void setPapeis(Papeis papeis) {
		this.papeis = papeis;
	}
}
