package br.com.ucb.tcc.util;

public class GerenciadorEmail {
	public static void enviarEmailConfirmacaoCadastro(String email, String senha) {
		try {
			EmailJava emailJava = new EmailJava();
			emailJava.enviarEmail("teste@gmail.com","Confirmação de cadastro","Seu cadastro simplificado foi realizado com sucesso!\n\n Email: "+email+"\n Senha: "+senha+"\n Acesse o sistema e conclua o cadastro completo.\n Link: http://localhost:9090/tcc/Login.xhtml",email);
			System.out.println("passou");
		} catch (Exception e) {
		System.out.println(e);
			// TODO: handle exception
		}
	}
	
}
	