package br.com.ucb.tcc.util;

public class GerenciadorEmail {
	public static void enviarEmailConfirmacaoCadastro(String email, String senha) {
	Runnable tarefa = new CadastroEmail(email, senha);
		Thread cadastroEmail = new Thread(tarefa);
		cadastroEmail.start();
	}
	
}
	