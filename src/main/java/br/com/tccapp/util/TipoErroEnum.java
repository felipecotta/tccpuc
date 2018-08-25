package br.com.tccapp.util;

public enum TipoErroEnum {

	SUCESSO(0,"Operação efetuada com Sucesso!"),
	ALERTA(1,"Atenção verifique a Situação"),
	ERRO  (2,"Houve um problema durante o processamento");
	
	private TipoErro tipoErro = new TipoErro();
	
	private TipoErroEnum(int codigo, String msgErro) {
		this.tipoErro.setCodigo(codigo);
		this.tipoErro.setMensagem(msgErro);
	}

	public TipoErro getTipoErro() {
		return tipoErro;
	}
	
	
}
