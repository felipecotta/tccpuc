package br.com.tccapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="municipios_brasileiros")
public class Municipio implements Serializable{

	private static final long serialVersionUID = 19306952206107800L;

	@Id
	@Column(name="codigo_ibge")
	private int codigoIbge;
	
	@Column(name="municipio")
	private String municipio;
	
	@Column(name="codigo_uf")
	private int codigoUf;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="latitude")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	
	public Municipio() {
		super();
	}


	public int getCodigoIbge() {
		return codigoIbge;
	}


	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public int getCodigoUf() {
		return codigoUf;
	}


	public void setCodigoUf(int codigoUf) {
		this.codigoUf = codigoUf;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
