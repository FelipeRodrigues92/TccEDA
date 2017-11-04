package br.com.ucb.tcc.modelo;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Certificacao {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Area area;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFim = Calendar.getInstance();


	@ManyToMany(mappedBy = "certificacoes", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ConteudoApto> conteudosAptos;
	
	
	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
