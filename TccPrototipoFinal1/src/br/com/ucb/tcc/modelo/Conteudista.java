package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
@DiscriminatorValue("C")
public class Conteudista extends Usuario{

	@OneToMany(mappedBy = "conteudista", fetch = FetchType.EAGER)
	@Fetch(value = org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Conteudo> conteudos;

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	
}
