package br.com.tccapp.util;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public abstract class UtilitarioSenha {

	private static Object salt;

	public static String generateHash(String password) {
		MessageDigestPasswordEncoder digestPasswordEncoder = getInstanceMessageDisterPassword();
		String encodePassword = digestPasswordEncoder.encodePassword(password, salt);
		return encodePassword;
	}

	private static MessageDigestPasswordEncoder getInstanceMessageDisterPassword() {//informo tipo de enconding que desejo 
		MessageDigestPasswordEncoder digestPasswordEncoder = new MessageDigestPasswordEncoder("SHA-256");
		return digestPasswordEncoder;
	}

	
	public static boolean isPasswordValid(String passwordSistema, String password) {
	
		String senhaHash = UtilitarioSenha.generateHash(password);
	
		if (passwordSistema.equals(senhaHash))
			return true;
		else
			return false;
	}

}
