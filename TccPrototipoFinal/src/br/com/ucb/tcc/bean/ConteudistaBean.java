package br.com.ucb.tcc.bean;

import javax.faces.bean.ManagedBean;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;

@ManagedBean
public class ConteudistaBean {

	private Conteudista conteudista = new Conteudista();

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}
	
	public void gravar(){
		System.out.println("Gravando conteudista" + this.conteudista.getNome());
		
		new ConteudistaDAO().gravar(this.conteudista); 
	}
}
