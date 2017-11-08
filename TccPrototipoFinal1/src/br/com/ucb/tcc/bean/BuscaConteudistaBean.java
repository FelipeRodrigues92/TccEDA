package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import br.com.ucb.tcc.dao.ConteudoAptoDAO;
import br.com.ucb.tcc.dao.CurriculoDAO;
import br.com.ucb.tcc.dao.DesdobramentoDAO;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Desdobramento;
import javassist.expr.NewArray;

@ManagedBean
public class BuscaConteudistaBean {
	private String nomeConteudo = "";
	
	public String getNomeConteudo() {
		return nomeConteudo;
	}



	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}

	public List<Curriculo> getConteudistas() {
		String nomeConteudo = getNomeConteudo();
		if (nomeConteudo.isEmpty()) {
			return null;
		}

	//	List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoPorDesdobramento(desdobramento);
		List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoCom(nomeConteudo);
		List<ConteudoApto> conteudosAptosPorDesdobramento = new ConteudoAptoDAO().getConteudoCom(nomeConteudo);
		List<Integer> desdobramentosId = new ArrayList<Integer>();
		
		for (ConteudoApto conteudoApto : conteudosAptos) {
			System.out.println("passou aqui 1 :"+ conteudoApto.getId());
			List<Integer> thisId = new DesdobramentoDAO().getDesdobramentoIdPorConteudo(conteudoApto.getId());
			System.out.println("passou aqui");
			desdobramentosId.addAll(thisId);
			//System.out.println("primeiro for"+ conteudoApto().);
//			if (!conteudoApto.getDesdobramentos().isEmpty()) {
//				for (Desdobramento ConteudoDesdobramento : conteudoApto.getDesdobramentos()) {
//					System.out.println("segundo for");
//					List<ConteudoApto> listaConteudosNovos = new ConteudoAptoDAO().getConteudoPorDesdobramento(desdobramento);
//					for (ConteudoApto conteudoApto2 : listaConteudosNovos) {
//						System.out.println("terceiro for");
//						if (conteudosAptos.contains(conteudoApto2)) {
//							listaConteudosNovos.remove(conteudoApto2);
//						}else {
//							conteudosAptos.add(conteudoApto2);
//						}
//						
//					}
//				}
//			}

		}
		for (Integer integer : desdobramentosId) {
			System.out.println(integer);
		}

		List<Curriculo> curriculosCursos = new ArrayList<Curriculo>();
		List<Curriculo> curriculosCertificacao = new ArrayList<Curriculo>();
		List<Curriculo> allCurriculos = new ArrayList<Curriculo>();
		List<Integer> curriculosId = new ArrayList<Integer>();
		// curriculosCursos.add(new ConteudoAptoDAO().getCurriculoCursoConteudo(4));

		for (ConteudoApto conteudoApto : conteudosAptos) {
			System.out.println(conteudoApto.getId() + ": " + conteudoApto.getTitulo());
			Curriculo curricloCurso = new ConteudoAptoDAO().getCurriculoCursoConteudo(conteudoApto.getId());
			Curriculo curricloCertificacao = new ConteudoAptoDAO()
					.getCurriculoCertificacaoConteudo(conteudoApto.getId());
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
				System.out.println(curriculo.getId());
				allCurriculos.add(curriculo);
				curriculosId.add(curriculo.getId());
			}
		}
		for (Integer integer : curriculosId) {
			System.out.println("Printando os id: "+curriculosId);
		}

		java.util.Collections.sort(allCurriculos);

		return allCurriculos;

	}
}
