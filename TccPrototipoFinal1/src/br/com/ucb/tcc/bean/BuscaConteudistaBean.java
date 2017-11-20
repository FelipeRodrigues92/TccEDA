package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import br.com.ucb.tcc.dao.ConteudoAptoDAO;
import br.com.ucb.tcc.dao.CurriculoDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.dao.DesdobramentoDAO;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Desdobramento;
import br.com.ucb.tcc.modelo.Endereco;
import javassist.expr.NewArray;

@ManagedBean
@SessionScoped
public class BuscaConteudistaBean {
	
	private boolean tipoBusca;
	
	private String nomeConteudo = "";
	
	private Curriculo curriculo;
	
	private Endereco endereco;
	
	private List<Curriculo> curriculos;
	
	public List<Curriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public boolean isTipoBusca() {
		return tipoBusca;
	}

	public void setTipoBusca(boolean tipoBusca) {
		this.tipoBusca = tipoBusca;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public String getNomeConteudo() {
		return nomeConteudo;
	}

	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}

	public void getConteudistas() {
		System.out.println("normal");
		String nomeConteudo = getNomeConteudo();
		if (nomeConteudo.isEmpty() || nomeConteudo == " ") {
			this.curriculos = null;
		}

		List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoCom(nomeConteudo);
		List<ConteudoApto> conteudosAptosPorDesdobramento = new ConteudoAptoDAO().getConteudoCom(nomeConteudo);
		List<String> desdobramentos = new ArrayList<String>();
		List<Integer> conteudosId = new ArrayList<Integer>();

		for (ConteudoApto conteudoApto : conteudosAptos) {
			if (!conteudosId.contains(conteudoApto.getId())) {
				conteudosId.add(conteudoApto.getId());
			}

			List<String> thisDesdobramentos = new DesdobramentoDAO()
					.getDesdobramentoDescricaoPorConteudo(conteudoApto.getId());
			for (String descricao : thisDesdobramentos) {
				if (!desdobramentos.contains(descricao)) {
					desdobramentos.add(descricao);
				}
			}

		}
		for (String descricao : desdobramentos) {
			conteudosAptosPorDesdobramento = new ConteudoAptoDAO().getConteudoPorDesdobramento(descricao);
			for (ConteudoApto conteudoApto : conteudosAptosPorDesdobramento) {
				if (!conteudosId.contains(conteudoApto.getId())) {
					conteudosId.add(conteudoApto.getId());
				}
			}
		}

		List<Curriculo> curriculosCursos = new ArrayList<Curriculo>();
		List<Curriculo> curriculosCertificacao = new ArrayList<Curriculo>();
		List<Curriculo> allCurriculos = new ArrayList<Curriculo>();
		List<Integer> curriculosId = new ArrayList<Integer>();


		for (Integer conteudoId : conteudosId) {
			Curriculo curricloCurso = new ConteudoAptoDAO().getCurriculoCursoConteudo(conteudoId);
			Curriculo curricloCertificacao = new ConteudoAptoDAO()
					.getCurriculoCertificacaoConteudo(conteudoId);
			if (curricloCurso != null) {
				curriculosCursos.add(curricloCurso);
			}
			if (curricloCertificacao != null) {
				curriculosCertificacao.add(curricloCertificacao);
			}
		}

		allCurriculos = curriculosCertificacao;

		for (Curriculo curriculo : curriculosCertificacao) {
			curriculosId.add(curriculo.getId());
		}

		for (Curriculo curriculo : curriculosCursos) {
			if (curriculosId.contains(curriculo.getId())) {
			} else {
				// System.out.println(curriculo.getId());
				allCurriculos.add(curriculo);
				curriculosId.add(curriculo.getId());
			}
		}

		java.util.Collections.sort(allCurriculos);

		this.curriculos = allCurriculos;

	}
	
	public String verCurriculoPor(Curriculo curriculo){
		this.curriculo = new DAO<Curriculo>(Curriculo.class).buscaPorId(curriculo.getId());
		
		return RotasBean.goCurriculoConteudista();
	}

	public void getConteudistasSimples() {
		System.out.println("simples");
		String nomeConteudo = getNomeConteudo();
		if (nomeConteudo.isEmpty() || nomeConteudo == " ") {
			this.curriculos = null;
		}

		List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoCom(nomeConteudo);
		List<Integer> conteudosId = new ArrayList<Integer>();

		for (ConteudoApto conteudoApto : conteudosAptos) {
			if (!conteudosId.contains(conteudoApto.getId())) {
				conteudosId.add(conteudoApto.getId());
			}
		}
		
		List<Curriculo> curriculosCursos = new ArrayList<Curriculo>();
		List<Curriculo> curriculosCertificacao = new ArrayList<Curriculo>();
		List<Curriculo> allCurriculos = new ArrayList<Curriculo>();
		List<Integer> curriculosId = new ArrayList<Integer>();


		for (Integer conteudoId : conteudosId) {
			Curriculo curricloCurso = new ConteudoAptoDAO().getCurriculoCursoConteudo(conteudoId);
			Curriculo curricloCertificacao = new ConteudoAptoDAO()
					.getCurriculoCertificacaoConteudo(conteudoId);
			if (curricloCurso != null) {
				curriculosCursos.add(curricloCurso);
			}
			if (curricloCertificacao != null) {
				curriculosCertificacao.add(curricloCertificacao);
			}
		}

		allCurriculos = curriculosCertificacao;

		for (Curriculo curriculo : curriculosCertificacao) {
			curriculosId.add(curriculo.getId());
		}

		for (Curriculo curriculo : curriculosCursos) {
			if (curriculosId.contains(curriculo.getId())) {
			} else {
				// System.out.println(curriculo.getId());
				allCurriculos.add(curriculo);
				curriculosId.add(curriculo.getId());
			}
		}

		java.util.Collections.sort(allCurriculos);

		this.curriculos = allCurriculos;

	}
}
