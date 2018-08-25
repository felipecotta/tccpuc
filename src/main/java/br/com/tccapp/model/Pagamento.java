package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pagamento database table.
 * 
 */
@Entity
@Table(name="pagamento")
@NamedQuery(name="Pagamento.findAll", query="SELECT p FROM Pagamento p")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_pagamento")
	private int codigoPagamento;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="numero_cartao")
	private String numeroCartao;

	private double valor;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	private Pedido pedido;

	public Pagamento() {
	}

	public int getCodigoPagamento() {
		return this.codigoPagamento;
	}

	public void setCodigoPagamento(int codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumeroCartao() {
		return this.numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}