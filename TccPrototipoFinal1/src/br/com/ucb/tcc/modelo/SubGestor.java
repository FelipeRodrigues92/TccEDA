package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("S")
public class SubGestor extends Usuario{

	
	@OneToMany(mappedBy= "subGestor")
	private List<Conteudo> conteudos;

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
}
