package com.projeto.salveViagens.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ViagemHosped {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idViagemHosped;
	@ManyToOne
	private Viagem viagem;
	@ManyToOne
	private Hospedagem hospede;
	private Date dataCheckIn;
	private Date dataCheckOut;
	public long getIdViagemHosped() {
		return idViagemHosped;
	}
	public void setIdViagemHosped(long idViagemHosped) {
		this.idViagemHosped = idViagemHosped;
	}
	public Viagem getViagem() {
		return viagem;
	}
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
	public Hospedagem getHospede() {
		return hospede;
	}
	public void setHospede(Hospedagem hospede) {
		this.hospede = hospede;
	}
	public Date getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	public Date getDataCheckOut() {
		return dataCheckOut;
	}
	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
	

}
