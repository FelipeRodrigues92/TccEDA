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
import br.com.ucb.tcc.modelo.Gestor;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.modelo.SubGestor;
import br.com.ucb.tcc.modelo.Usuario;

@ManagedBean
public class GestorBean {

	private Endereco endereco = new Endereco();
	
	private Curriculo curriculo = new Curriculo();
	
	private Gestor gestor = new Gestor();
	
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

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public String buscaConteudo() {
		System.out.println("Chamando  o formulário do curso");
		return "BuscaConteudo?faces-redirect=true";
	}
	public String buscaConteudista() {
		System.out.println("Chamando  o formulário do curso");
		return "BuscaConteudo?faces-redirect=true";
	}
	public List<Gestor> getPerfil() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Gestor gestor = new DAO<Gestor>(Gestor.class).buscaPorId(usuarioId);
		List<Gestor> lista = new ArrayList<Gestor>();
		lista.add(gestor);
		return lista;
	}
	
}
