package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historico_estoque database table.
 * 
 */
@Entity
@Table(name="historico_estoque")
@NamedQuery(name="HistoricoEstoque.findAll", query="SELECT h FROM HistoricoEstoque h")
public class HistoricoEstoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idhistorico_estoque")
	private long idhistoricoEstoque;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="flag_es")
	private String flagEs;

	private int quantidade;

	private double valor;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	private Produto produto;

	public HistoricoEstoque() {
	}

	public long getIdhistoricoEstoque() {
		return this.idhistoricoEstoque;
	}

	public void setIdhistoricoEstoque(long idhistoricoEstoque) {
		this.idhistoricoEstoque = idhistoricoEstoque;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFlagEs() {
		return this.flagEs;
	}

	public void setFlagEs(String flagEs) {
		this.flagEs = flagEs;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}