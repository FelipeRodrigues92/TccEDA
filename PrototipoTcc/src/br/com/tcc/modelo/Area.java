package br.com.tcc.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Area {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoArea tipoArea;
	
	@ManyToMany
	private List<Desdobramento> desdobramentos;
	
	@OneToMany(mappedBy = "area")
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "areaCertificacao")
	private List<Certificacao> certificacoes;
}
