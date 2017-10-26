package br.com.ucb.tcc.bean;

import javax.faces.bean.ManagedBean;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Endereco;

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
	
	public void gravar(){
		System.out.println("Gravando conteudista" + this.conteudista.getNome());
		
		this.conteudista.setEndereco(this.endereco);
		this.curriculo.setConteudista(this.conteudista);
		new ConteudistaDAO().gravar(this.conteudista, this.endereco, this.curriculo); 
	}
}
