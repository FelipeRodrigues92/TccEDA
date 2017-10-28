package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Certificacao {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Integer nivel;
	private Area area;
	
	@ManyToMany
	private List<Curriculo> curriculos;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Curriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public List<ConteudoApto> getConteudosAptos() {
		return ConteudosAptos;
	}

	public void setConteudosAptos(List<ConteudoApto> conteudosAptos) {
		ConteudosAptos = conteudosAptos;
	}

	@OneToMany(mappedBy = "certificacao", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ConteudoApto> ConteudosAptos;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	
}
