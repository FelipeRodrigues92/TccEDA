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

	private SubGestor subGestor = new SubGestor();
	
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

	
	
	public SubGestor getSubGestor() {
		return subGestor;
	}

	public void setSubGestor(SubGestor subGestor) {
		this.subGestor = subGestor;
	}

	public String formCurso() {
		System.out.println("Chamando  o formulário do curso");
		return "CadastroCurso?faces-redirect=true";
	}
	public List<SubGestor> getPerfil() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		SubGestor subGestor = new DAO<SubGestor>(SubGestor.class).buscaPorId(usuarioId);
		List<SubGestor> lista = new ArrayList<SubGestor>();
		lista.add(subGestor);
		return lista;
	}
	
}
