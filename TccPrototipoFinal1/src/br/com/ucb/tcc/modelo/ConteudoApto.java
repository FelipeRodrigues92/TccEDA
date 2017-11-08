package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ConteudoApto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Desdobramento> getDesdobramentos() {
		return desdobramentos;
	}

	public void setDesdobramentos(List<Desdobramento> desdobramentos) {
		this.desdobramentos = desdobramentos;
	}


	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Certificacao> getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(List<Certificacao> certificacoes) {
		this.certificacoes = certificacoes;
	}

	private String titulo;
	
	@ManyToMany
	private List<Desdobramento> desdobramentos;
	
	@ManyToMany
	private List<Curso> cursos;
	
	@ManyToMany
	private List<Certificacao> certificacoes;
}
