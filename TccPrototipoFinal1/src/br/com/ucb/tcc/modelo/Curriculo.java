package br.com.ucb.tcc.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
public class Curriculo implements Comparable<Curriculo>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(unique = true)
	@OneToOne(fetch = FetchType.EAGER)
	private Conteudista conteudista;

	@OneToMany(mappedBy = "curriculo", fetch= FetchType.EAGER)
	@Fetch(value = org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Curso> cursos;

	@ManyToMany(mappedBy = "curriculos", fetch = FetchType.EAGER)
	@Fetch(value = org.hibernate.annotations.FetchMode.SUBSELECT)
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

	public Integer getPontuacao() {
		Integer pontuacao = 0;
		Integer showcont = 0;
		Integer cont = 0;
		List<Conteudo> conteudos = this.getConteudista().getConteudos();

		if (conteudista.getConteudos().isEmpty()) {
		} else {
			conteudos = conteudista.getConteudos();
		}

		for (Certificacao certificacao : certificacoes) {
			pontuacao = pontuacao + 10;
		}

		for (Curso curso : cursos) {
			pontuacao = pontuacao + curso.getId();

		}
		if (conteudos.size() > 0) {
			for (Conteudo conteudo : conteudos) {
				pontuacao = pontuacao + (conteudo.getAvaliacao() * 2);
			}
		}
		return pontuacao;
	}

	@Override
	public int compareTo(Curriculo outroCurriculo) {
		 if (this.getPontuacao() > outroCurriculo.getPontuacao()) {
	          return -1;
	     }
	     if (this.getPontuacao() < outroCurriculo.getPontuacao()) {
	          return 1;
	     }
	     return 0;
	}

}
