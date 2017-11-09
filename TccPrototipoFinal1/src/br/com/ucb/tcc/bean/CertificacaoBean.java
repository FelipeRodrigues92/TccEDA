package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.CertificacaoDAO;
import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.CurriculoDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Certificacao;

@ManagedBean
public class CertificacaoBean {
	
	private Certificacao certificacao = new Certificacao();

	
	public Certificacao getCertificacao() {
		return certificacao;
	}



	public void setCertificacao(Certificacao certificacao) {
		certificacao = certificacao;
	}

	public String formHome() {
		System.out.println("Chamando  o formulário do home");
		return "Home?faces-redirect=true";
	}

	public String gravar(){
		System.out.println("Gravando conteudista" + this.certificacao.getNome());
		
		//Buscar curriculo pelo id do usuario
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");


		Curriculo curriculo = new CurriculoDAO().getCurriculoPorUserId(usuarioId);
//		curriculo.;
		List<Curriculo> listCurriculos = new ArrayList<Curriculo>();
		listCurriculos.add(curriculo);
		
		List<Certificacao> certificacoes = new ArrayList<Certificacao>();
		certificacoes.add(certificacao);
		
		curriculo.setCertificacoes(certificacoes);
		this.certificacao.setCurriculos(listCurriculos);
		
		
		new CertificacaoDAO().gravar(curriculo, certificacao);
		return RotasBean.goCadastroFeito();
	}
	public void remover(Certificacao certificacao) {
		System.out.println("Removendo certificação");
		new DAO<Certificacao>(Certificacao.class).remove(certificacao);
	}
}
