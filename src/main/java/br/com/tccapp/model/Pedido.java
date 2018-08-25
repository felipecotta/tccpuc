package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_pedido")
	private long codigoPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pedido")
	private Date dataPedido;

	//bi-directional many-to-one association to Itenspedido
	@OneToMany(mappedBy="pedido")
	private List<Itenspedido> itenspedidos;

	//bi-directional many-to-one association to Nf
	@OneToMany(mappedBy="pedido")
	private List<Nf> nfs;

	//bi-directional many-to-one association to Pagamento
	@OneToMany(mappedBy="pedido")
	private List<Pagamento> pagamentos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public Pedido() {
	}

	public long getCodigoPedido() {
		return this.codigoPedido;
	}

	public void setCodigoPedido(long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Itenspedido> getItenspedidos() {
		return this.itenspedidos;
	}

	public void setItenspedidos(List<Itenspedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}

	public Itenspedido addItenspedido(Itenspedido itenspedido) {
		getItenspedidos().add(itenspedido);
		itenspedido.setPedido(this);

		return itenspedido;
	}

	public Itenspedido removeItenspedido(Itenspedido itenspedido) {
		getItenspedidos().remove(itenspedido);
		itenspedido.setPedido(null);

		return itenspedido;
	}

	public List<Nf> getNfs() {
		return this.nfs;
	}

	public void setNfs(List<Nf> nfs) {
		this.nfs = nfs;
	}

	public Nf addNf(Nf nf) {
		getNfs().add(nf);
		nf.setPedido(this);

		return nf;
	}

	public Nf removeNf(Nf nf) {
		getNfs().remove(nf);
		nf.setPedido(null);

		return nf;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setPedido(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setPedido(null);

		return pagamento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}