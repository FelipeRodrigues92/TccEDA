package br.com.ucb.tcc.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String instituicao;
	private Area area;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFim = Calendar.getInstance();
	
	@ManyToOne(fetch=FetchType.EAGER)
	private NivelCurso nivelCurso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private BancoCurso bancoCurso;
	

	public BancoCurso getBancoCurso() {
		return bancoCurso;
	}

	public void setBancoCurso(BancoCurso bancoCurso) {
		this.bancoCurso = bancoCurso;
	}

	public NivelCurso getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(NivelCurso nivelCurso) {
		this.nivelCurso = nivelCurso;
	}


	public List<ConteudoApto> getConteudosAptos() {
		return conteudosAptos;
	}

	public void setConteudosAptos(List<ConteudoApto> conteudosAptos) {
		this.conteudosAptos = conteudosAptos;
	}


	@ManyToOne
	private Curriculo curriculo;
	
	@ManyToMany(mappedBy = "cursos", fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private List<ConteudoApto> conteudosAptos;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
