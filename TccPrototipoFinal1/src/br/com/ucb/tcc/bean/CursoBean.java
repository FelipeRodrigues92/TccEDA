package br.com.ucb.tcc.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.CurriculoDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.BancoCurso;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.NivelCurso;

@ManagedBean
@ViewScoped
public class CursoBean {
	
	private Curso curso = new Curso();
	
	private NivelCurso nivelCurso = new NivelCurso();
	
	private BancoCurso bancoCurso = new BancoCurso();
	
	private Integer nivelCursoId;
	
	private Integer bancoCursoId;
	
	public Integer getBancoCursoId() {
		return bancoCursoId;
	}

	public void setBancoCursoId(Integer bancoCursoId) {
		this.bancoCursoId = bancoCursoId;
	}
	
	
	public Integer getNivelCursoId() {
		return nivelCursoId;
	}

	public void setNivelCursoId(Integer nivelCursoId) {
		this.nivelCursoId = nivelCursoId;
	}

	public NivelCurso getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(NivelCurso nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<NivelCurso> getNivelCursos(){
		return new DAO<NivelCurso>(NivelCurso.class).listaTodos();
	}
	
	public List<BancoCurso> getBancoCursos(){
		return new DAO<BancoCurso>(BancoCurso.class).listaTodos();
	}
	public String formCertificacao() {
		System.out.println("Chamando  o formulário do certificação");
		return "CadastroCertificacao?faces-redirect=true";
	}
	
	public String gravar(){
		System.out.println("Gravando conteudista" + this.curso.getName());
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Curriculo curriculo = new CurriculoDAO().getCurriculoPorUserId(usuarioId);
		System.out.println(usuarioId);
		System.out.println(curriculo.getId());
//		curriculo.;
		
		this.nivelCurso = new DAO<NivelCurso>(NivelCurso.class).buscaPorId(nivelCursoId);
		this.bancoCurso = new DAO<BancoCurso>(BancoCurso.class).buscaPorId(bancoCursoId);
		
		this.curso.setBancoCurso(bancoCurso);
		this.curso.setCurriculo(curriculo);
		this.curso.setNivelCurso(this.nivelCurso);
		new DAO<Curso>(Curso.class).adiciona(this.curso); 
		return this.goCadastroFeito();
	}
	public BancoCurso getBancoCurso() {
		return bancoCurso;
	}

	public void setBancoCurso(BancoCurso bancoCurso) {
		this.bancoCurso = bancoCurso;
	}

	public void remover(Curso curso) {
		System.out.println("Removendo livro");
		new DAO<Curso>(Curso.class).remove(curso);
	}
	public String carregar(Curso curso) {
		System.out.println("Chamando  o formulário do certificação");
		this.curso = curso;
		return "CadastroCurso?faces-redirect=true";
	}
	public String goCurso() {
		return "CadastroCurso?faces-redirect=true";
	}
	public String goCadastroFeito() {
		return "CasdatroFeito?faces-redirect=true";
	}
	public String goCursoConteudo() {
		return "CadastroConteudoAptoPorCurso?faces-redirect=true";
	}
}
