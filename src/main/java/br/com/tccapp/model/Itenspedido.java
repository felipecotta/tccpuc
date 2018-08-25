package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itenspedido database table.
 * 
 */
@Entity
@Table(name="itenspedido")
@NamedQuery(name="Itenspedido.findAll", query="SELECT i FROM Itenspedido i")
public class Itenspedido implements Serializable {
	private static final long serialVersionUID = 1L;

	private int quantidade;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_intenspedido")
	private long id_itenspedido;
	
	//bi-directional many-to-one association to Pedido
	@ManyToOne
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	private Produto produto;

	public Itenspedido() {
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public long getId_itenspedido() {
		return id_itenspedido;
	}

	public void setId_itenspedido(long id_itenspedido) {
		this.id_itenspedido = id_itenspedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}