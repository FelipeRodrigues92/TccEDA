package br.com.ucb.tcc.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Curriculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(unique = true)
	@OneToOne
	private Conteudista conteudista;	
	
	@OneToMany(mappedBy="curriculo")
	private List<Curso> cursos;
	
	@ManyToMany(mappedBy = "curriculos")
	private List<Certificacao> certificacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
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
	
	
}
