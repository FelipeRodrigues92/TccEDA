package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucb.tcc.dao.ConteudoAptoDAO;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;

@ManagedBean
public class BuscaConteudistaBean {
	private String desdobramento = "";

	public String getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(String desdobramento) {
		this.desdobramento = desdobramento;
	}
	
	public List<Curriculo> getConteudistas(){
		String desdobramento = getDesdobramento();
		if(desdobramento.isEmpty()){
			return null;
		}
		List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoPorDesdobramento(desdobramento); 
		List<Curriculo> curriculosCursos = new ArrayList<Curriculo>();
		List<Curriculo> curriculosCertificacao = new ArrayList<Curriculo>();
//		curriculosCursos.add(new ConteudoAptoDAO().getCurriculoCursoConteudo(4));
		
		
		for (ConteudoApto conteudoApto : conteudosAptos) {
			System.out.println(conteudoApto.getId() +": "+conteudoApto.getTitulo());
			Curriculo curricloCurso = new ConteudoAptoDAO().getCurriculoCursoConteudo(conteudoApto.getId());
			Curriculo curricloCertificacao = new ConteudoAptoDAO().getCurriculoCertificacaoConteudo(conteudoApto.getId());
			if(curricloCurso != null) {
				curriculosCursos.add(new ConteudoAptoDAO().getCurriculoCursoConteudo(conteudoApto.getId()));
			}
			if(curricloCertificacao != null) {
				curriculosCertificacao.add(new ConteudoAptoDAO().getCurriculoCertificacaoConteudo(conteudoApto.getId()));
			}
		}
		for (Curriculo curriculo : curriculosCursos) {
			System.out.println(curriculo.getId());
		}
		System.out.println("view");
		return null;
		
	}
}
