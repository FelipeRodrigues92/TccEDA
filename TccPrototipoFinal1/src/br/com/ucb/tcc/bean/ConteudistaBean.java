package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.modelo.Usuario;

@ManagedBean
public class ConteudistaBean {

	private Endereco endereco = new Endereco();
	
	private Curriculo curriculo = new Curriculo();
	
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

	private Conteudista conteudista = new Conteudista();

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}
	public String formCurso() {
		System.out.println("Chamando  o formulário do curso");
		return "CadastroCurso?faces-redirect=true";
	}
	public List<Conteudista> getPerfil() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Conteudista conteudista = new DAO<Conteudista>(Conteudista.class).buscaPorId(usuarioId);
		List<Conteudista> lista = new ArrayList<Conteudista>();
		lista.add(conteudista);
		return lista;
	}
	
	public String gravar(){
		System.out.println("Gravando conteudista" + this.conteudista.getNome());
		
		this.conteudista.setEndereco(this.endereco);
		this.curriculo.setConteudista(this.conteudista);
		Login login = new Login();
		login.setEmail(conteudista.getEmail());
		login.setSenha(conteudista.getSenha());
		new DAO<Login>(Login.class).adiciona(login);
		new ConteudistaDAO().gravar(this.conteudista, this.endereco, this.curriculo); 
		return "Curso?faces-redirect=true";
	}
	public Boolean isADM(){
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if(usuarioId ==1) {
			return true;
		}
		return false;
	}
	public Boolean isSubADM(){
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if(usuarioId == 2) {
			return true;
		}
		return false;
	}
	public Boolean isSubADMOrADM(){
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if(usuarioId == 2 || usuarioId == 2) {
			return true;
		}
		return false;
	}
}
