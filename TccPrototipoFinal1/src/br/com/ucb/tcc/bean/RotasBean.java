package br.com.ucb.tcc.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RotasBean {
	public static String goHome() {
		return "Home?faces-redirect=true";
	}
	public static String goSubHome() {
		return "HomeSubAdm?faces-redirect=true";
	}
	public static String goShowAvisoCadastro() {
		return "ShowAvisoCadastro?faces-redirect=true";
	}
	public static String goCertificacao() {
		return "CadastroCertificacao?faces-redirect=true";
	}
	public static String goCurso() {
		return "CadastroCurso?faces-redirect=true";
	}
	public static String goCadastroFeito() {
		return "CadastroFeito?faces-redirect=true";
	}
	public static String goConteudo() {
		return "CadastroConteudoApto?faces-redirect=true";
	}
	public static String goLogin() {
		return "Login?faces-redirect=true";
	}
	public static String goGerenciarConteudista() {
		return "GerenciarConteudista?faces-redirect=true";
	}
	public static String goTodosDados() {
		return "ShowDados?faces-redirect=true";
	}
	public static String goBuscaConteudo() {
		return "BuscaConteudo?faces-redirect=true";
	}
	public static String goBuscaConteudista() {
		return "BuscaConteudista?faces-redirect=true";
	}
	public static String goCadastroConteudo() {
		return "CadastroConteudo?faces-redirect=true";
	}
}

