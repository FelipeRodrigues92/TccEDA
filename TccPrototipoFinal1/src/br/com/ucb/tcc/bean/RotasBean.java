package br.com.ucb.tcc.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RotasBean {
	public String goHome() {
		return "Home?faces-redirect=true";
	}
	public String goCertificacao() {
		return "CadastroCertificacao?faces-redirect=true";
	}
	public String goCurso() {
		return "CadastroCurso?faces-redirect=true";
	}
	public String goCadastroFeito() {
		return "Encaminhamento?faces-redirect=true";
	}
	public String goConteudo() {
		return "CadastroConteudoAptoPorCurso?faces-redirect=true";
	}
}
