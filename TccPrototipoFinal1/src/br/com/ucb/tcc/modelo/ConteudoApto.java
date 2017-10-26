package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.Entity;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Certificacao getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Certificacao certificacao) {
		this.certificacao = certificacao;
	}

	private String titulo;
	
	@ManyToMany
	private List<Desdobramento> desdobramentos;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Certificacao certificacao;
}
