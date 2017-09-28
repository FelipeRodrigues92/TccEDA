package br.com.tcc.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certificacao {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Integer nivel;
	
	@ManyToOne
	private Area areaCertificacao;

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

	public Area getAreaCertificacao() {
		return areaCertificacao;
	}

	public void setAreaCertificacao(Area areaCertificacao) {
		this.areaCertificacao = areaCertificacao;
	}
	
}
