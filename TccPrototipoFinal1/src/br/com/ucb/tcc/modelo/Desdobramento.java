package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Desdobramento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	
	@ManyToMany(mappedBy= "desdobramentos")
	private List<ConteudoApto> conteudosAptos;
	
	public List<ConteudoApto> getConteudosAptos() {
		return conteudosAptos;
	}
	public void setConteudosAptos(List<ConteudoApto> conteudosAptos) {
		this.conteudosAptos = conteudosAptos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
