package br.com.ucb.tcc.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Conteudo;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.NivelCurso;
import br.com.ucb.tcc.modelo.SubGestor;

@ManagedBean
@SessionScoped
public class ConteudoBean {
	Conteudo conteudo = new Conteudo();
	Conteudista conteudista = new Conteudista();
	Integer conteudistaId;
	

	public Integer getConteudistaId() {
		return conteudistaId;
	}

	public void setConteudistaId(Integer conteudistaId) {
		this.conteudistaId = conteudistaId;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	public List<Conteudista> getConteudistas(){
		return new DAO<Conteudista>(Conteudista.class).listaTodos();
	}
	public String gravar(){
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		SubGestor subGestor = new DAO<SubGestor>(SubGestor.class).buscaPorId(usuarioId);
		
		Conteudista conteudistaNovo = new DAO<Conteudista>(Conteudista.class).buscaPorId(conteudistaId);
		
		this.conteudo.setSubGestor(subGestor);
		this.conteudo.setConteudista(conteudistaNovo);
		new DAO<Conteudo>(Conteudo.class).adiciona(this.conteudo); 
		
		this.conteudo = new Conteudo();
		return RotasBean.goConteudosDesenvolvidos();
	}
	public void remover(Conteudo conteudo) {
		new DAO<Conteudo>(Conteudo.class).remove(conteudo);
	}
	public List<Conteudo> getAllConteudos(){
		List<Conteudo> conteudos = new DAO<Conteudo>(Conteudo.class).listaTodos();
		return conteudos;
	}
	public String alterar() {
		
		new DAO<Conteudo>(Conteudo.class).atualiza(this.conteudo);
		this.conteudo = new Conteudo();
		return RotasBean.goConteudosDesenvolvidos();
	}
	public String carregar(Conteudo conteudo) {
		this.conteudo = conteudo;
		this.conteudista = conteudo.getConteudista();
		return RotasBean.goAlteraConteudosDesenvolvidos();
	}
	public String goSubHome() {
		this.conteudo = new Conteudo();
		return "HomeSubAdm?faces-redirect=true";
	}
}
