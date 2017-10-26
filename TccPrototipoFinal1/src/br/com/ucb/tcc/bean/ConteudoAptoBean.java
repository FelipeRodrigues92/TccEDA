package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.CertificacaoDAO;
import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.ConteudoAptoDAO;
import br.com.ucb.tcc.dao.CurriculoDAO;
import br.com.ucb.tcc.dao.CursoDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Desdobramento;
import br.com.ucb.tcc.modelo.NivelCurso;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Certificacao;

@ManagedBean
public class ConteudoAptoBean {

	private ConteudoApto conteudoApto = new ConteudoApto();
	private Desdobramento desdobramento1 = new Desdobramento();
	private Desdobramento desdobramento2 = new Desdobramento();
	private Desdobramento desdobramento3 = new Desdobramento();
	private Desdobramento desdobramento4 = new Desdobramento();
	private Desdobramento desdobramento5 = new Desdobramento();

	private Integer CursoId;
	private Integer CertificacaoId;

	public Desdobramento getDesdobramento1() {
		return desdobramento1;
	}

	public void setDesdobramento1(Desdobramento desdobramento1) {
		this.desdobramento1 = desdobramento1;
	}

	public Desdobramento getDesdobramento2() {
		return desdobramento2;
	}

	public void setDesdobramento2(Desdobramento desdobramento2) {
		this.desdobramento2 = desdobramento2;
	}

	public Desdobramento getDesdobramento3() {
		return desdobramento3;
	}

	public void setDesdobramento3(Desdobramento desdobramento3) {
		this.desdobramento3 = desdobramento3;
	}

	public Desdobramento getDesdobramento4() {
		return desdobramento4;
	}

	public void setDesdobramento4(Desdobramento desdobramento4) {
		this.desdobramento4 = desdobramento4;
	}

	public Desdobramento getDesdobramento5() {
		return desdobramento5;
	}

	public void setDesdobramento5(Desdobramento desdobramento5) {
		this.desdobramento5 = desdobramento5;
	}

	public ConteudoApto getConteudoApto() {
		return conteudoApto;
	}

	public Integer getCursoId() {
		return CursoId;
	}

	public void setCursoId(Integer cursoId) {
		CursoId = cursoId;
	}

	public Integer getCertificacaoId() {
		return CertificacaoId;
	}

	public void setCertificacaoId(Integer certificacaoId) {
		CertificacaoId = certificacaoId;
	}

	public void setConteudoApto(ConteudoApto conteudoApto) {
		this.conteudoApto = conteudoApto;
	}

	public List<Curso> getCursos() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Curriculo curriculo = (Curriculo) new CurriculoDAO().getCurriculoPorUserId(usuarioId);
		return new CursoDAO().getCursos(curriculo);
	}

	public List<Certificacao> getCertificacoes() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Curriculo curriculo = (Curriculo) new CurriculoDAO().getCurriculoPorUserId(usuarioId);
		return new CertificacaoDAO().getCerfiticacoes(curriculo);
	}

	public void gravarPorCurso() {

		// Buscar curriculo pelo id do usuario
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Curriculo curriculo = (Curriculo) new CurriculoDAO().getCurriculoPorUserId(usuarioId);
		//Curriculo curriculo = new DAO<Curriculo>(Curriculo.class).buscaPorId(1);
		// curriculo.;
		Curso curso = new DAO<Curso>(Curso.class).buscaPorId(CursoId);

		List<Desdobramento> desdobramentos = new ArrayList<Desdobramento>();
		desdobramentos.add(desdobramento1);
		desdobramentos.add(desdobramento2);
		desdobramentos.add(desdobramento3);
		desdobramentos.add(desdobramento4);
		desdobramentos.add(desdobramento5);

		this.conteudoApto.setDesdobramentos(desdobramentos);// getDesdobramentos().add(desdobramento1);//
															// setDesdobramentos(desdobramentos);
		this.conteudoApto.setCurso(curso);

		new ConteudoAptoDAO().gravar(this.conteudoApto);
	}

	public void gravarPorCertificacao() {

		// Buscar curriculo pelo id do usuario
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Curriculo curriculo = (Curriculo) new CurriculoDAO().getCurriculoPorUserId(usuarioId);
	//	Curriculo curriculo = new DAO<Curriculo>(Curriculo.class).buscaPorId(1);
		// curriculo.;
		Certificacao certificacao = new DAO<Certificacao>(Certificacao.class).buscaPorId(CertificacaoId);

		List<Desdobramento> desdobramentos = new ArrayList<Desdobramento>();
		desdobramentos.add(desdobramento1);
		desdobramentos.add(desdobramento2);
		desdobramentos.add(desdobramento3);
		desdobramentos.add(desdobramento4);
		desdobramentos.add(desdobramento5);

		this.conteudoApto.setDesdobramentos(desdobramentos);// getDesdobramentos().add(desdobramento1);//
															// setDesdobramentos(desdobramentos);
		this.conteudoApto.setCertificacao(certificacao);

		new ConteudoAptoDAO().gravar(this.conteudoApto);
	}

}
