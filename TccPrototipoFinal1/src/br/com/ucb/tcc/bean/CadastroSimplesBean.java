package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.util.GerenciadorEmail;

@ManagedBean
public class CadastroSimplesBean {
	private Endereco endereco = new Endereco();

	private Curriculo curriculo = new Curriculo();

	private Conteudista conteudista = new Conteudista();

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}

	public String gravar() {

		this.conteudista.setEndereco(this.endereco);
		this.curriculo.setConteudista(this.conteudista);
		Login login = new Login();
		login.setEmail(conteudista.getEmail());
		login.setSenha(conteudista.getSenha());
		new DAO<Login>(Login.class).adiciona(login);
		new ConteudistaDAO().gravar(this.conteudista, this.endereco, this.curriculo);
		GerenciadorEmail.enviarEmailConfirmacaoCadastro(conteudista.getEmail(), conteudista.getSenha());
		return RotasBean.goShowAvisoCadastro();
	}
}
