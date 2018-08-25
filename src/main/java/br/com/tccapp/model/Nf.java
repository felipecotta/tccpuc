package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nf database table.
 * 
 */
@Entity
@Table(name="nf")
@NamedQuery(name="Nf.findAll", query="SELECT n FROM Nf n")
public class Nf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_nf")
	private long codigoNf;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	private Pedido pedido;

	public Nf() {
	}

	public long getCodigoNf() {
		return this.codigoNf;
	}

	public void setCodigoNf(long codigoNf) {
		this.codigoNf = codigoNf;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}