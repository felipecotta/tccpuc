package br.com.tccapp.util;

public class TipoErro  {

	Integer codigo;
	String  mensagem;

	public TipoErro() {
	}
	
	
	public TipoErro(Integer codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}


	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	} 
	
	
	
	
}
