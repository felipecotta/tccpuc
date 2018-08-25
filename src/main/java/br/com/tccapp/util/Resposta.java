package br.com.tccapp.util;

import java.util.ArrayList;
import java.util.List;

public class Resposta  {

	private TipoErro resultadoOperacao;
	private List<String> msgErro;
	
	
	public Resposta() {
		this.resultadoOperacao = TipoErroEnum.SUCESSO.getTipoErro();
		msgErro = new ArrayList<>() ;
	}


	public TipoErro getResultadoOperacao() {
		return resultadoOperacao;
	}


	public void setResultadoOperacao(TipoErro resultadoOperacao) {
		this.resultadoOperacao = resultadoOperacao;
	}


	public List<String> getMsgErro() {
		return msgErro;
	}


}
