package br.com.tccapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo_produto")
	private long codigoProduto;

	@Column(name="descricao_produto")
	private String descricaoProduto;

	@Column(name="nome_produto")
	private String nomeProduto;

	@Column(name="quantidade_estoque")
	private int quantidadeEstoque;

	private double valor;

	//bi-directional many-to-one association to HistoricoEstoque
	@OneToMany(mappedBy="produto")
	private List<HistoricoEstoque> historicoEstoques;

	//bi-directional many-to-one association to Itenspedido
	@OneToMany(mappedBy="produto")
	private List<Itenspedido> itenspedidos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	public Produto() {
	}

	public long getCodigoProduto() {
		return this.codigoProduto;
	}

	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricaoProduto() {
		return this.descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidadeEstoque() {
		return this.quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<HistoricoEstoque> getHistoricoEstoques() {
		return this.historicoEstoques;
	}

	public void setHistoricoEstoques(List<HistoricoEstoque> historicoEstoques) {
		this.historicoEstoques = historicoEstoques;
	}

	public HistoricoEstoque addHistoricoEstoque(HistoricoEstoque historicoEstoque) {
		getHistoricoEstoques().add(historicoEstoque);
		historicoEstoque.setProduto(this);

		return historicoEstoque;
	}

	public HistoricoEstoque removeHistoricoEstoque(HistoricoEstoque historicoEstoque) {
		getHistoricoEstoques().remove(historicoEstoque);
		historicoEstoque.setProduto(null);

		return historicoEstoque;
	}

	public List<Itenspedido> getItenspedidos() {
		return this.itenspedidos;
	}

	public void setItenspedidos(List<Itenspedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}

	public Itenspedido addItenspedido(Itenspedido itenspedido) {
		getItenspedidos().add(itenspedido);
		itenspedido.setProduto(this);

		return itenspedido;
	}

	public Itenspedido removeItenspedido(Itenspedido itenspedido) {
		getItenspedidos().remove(itenspedido);
		itenspedido.setProduto(null);

		return itenspedido;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}