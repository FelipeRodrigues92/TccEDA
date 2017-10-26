package br.com.ucb.tcc.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Calendar dataInicio = Calendar.getInstance();;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFim = Calendar.getInstance();;
	
	@ManyToOne
	private NivelCurso nivelCurso;
	
	public NivelCurso getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(NivelCurso nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

	public List<ConteudoApto> getConteudosAptos() {
		return ConteudosAptos;
	}

	public void setConteudosAptos(List<ConteudoApto> conteudosAptos) {
		ConteudosAptos = conteudosAptos;
	}

	@ManyToOne
	private Curriculo curriculo;
	
	@OneToMany(mappedBy = "curso")
	private List<ConteudoApto> ConteudosAptos;
	
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
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
