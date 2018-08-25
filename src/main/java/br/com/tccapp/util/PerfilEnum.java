package br.com.tccapp.util;

import br.com.tccapp.model.Perfil;

public enum PerfilEnum {
	
	USUARIO(1,"usuario"),
	ADMIN(2,"admin");
	
	Perfil perfil = new Perfil();
	
	private PerfilEnum(int num , String descricao) {
		
		this.perfil.setIdPerfil(num);
		this.perfil.setTipoPerfil(descricao);
	}

	public Perfil getPerfil() {
		return this.perfil;
	}
	
	
	
}
