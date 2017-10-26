package br.com.ucb.tcc.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Conteudo;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.NivelCurso;
import br.com.ucb.tcc.modelo.SubGestor;

@ManagedBean
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
	public void gravar(){
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		SubGestor subGestor = new DAO<SubGestor>(SubGestor.class).buscaPorId(usuarioId);
		this.conteudista = new DAO<Conteudista>(Conteudista.class).buscaPorId(conteudistaId);
		
		this.conteudo.setSubGestor(subGestor);
		this.conteudo.setConteudista(conteudista);
		new DAO<Conteudo>(Conteudo.class).adiciona(this.conteudo); 
		
	}
	public void remover(Conteudo conteudo) {
		System.out.println("Removendo livro");
		new DAO<Conteudo>(Conteudo.class).remove(conteudo);
	}
	public String carregar(Conteudo conteudo) {
		System.out.println("Chamando  o formulário do certificação");
		this.conteudo = conteudo;
		return "CadastroCurso?faces-redirect=true";
	}
}
