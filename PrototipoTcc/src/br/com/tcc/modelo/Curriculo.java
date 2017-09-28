package br.com.tcc.modelo;

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
	
	@ManyToMany
	private List<Certificacao> certificacoes;
}
