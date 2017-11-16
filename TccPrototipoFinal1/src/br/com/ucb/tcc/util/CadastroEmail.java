package br.com.ucb.tcc.util;

public class CadastroEmail implements Runnable {
	private String email;
	private String senha;

	
	
	public CadastroEmail(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}



	@Override
	public void run() {

		try {
			EmailJava emailJava = new EmailJava();
			emailJava.enviarEmail("teste@gmail.com","Confirmação de cadastro","Seu cadastro simplificado foi realizado com sucesso!\n\n Email: "+this.email+"\n Senha: "+senha+"\n Acesse o sistema e conclua o cadastro completo.\n Link: http://localhost:9090/tcc/Login.xhtml",this.email);
			System.out.println("passou");
		} catch (Exception e) {
		System.out.println(e);
			// TODO: handle exception
		}	
	}
}
