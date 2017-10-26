package br.com.ucb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Endereco;

public class CertificacaoDAO {
	public void gravar(Curriculo curriculo, Certificacao certificacao) {
	EntityManager em = new JPAUtil().getEntityManager();

	// abre transacao
	em.getTransaction().begin();

	// persiste o objeto
	em.persist(certificacao);
	//em.merge(curriculo);
	//em.persist(certificacao);
	// commita a transacao
	em.getTransaction().commit();

	// fecha a entity manager
	em.close();
	}
	
	public List<Certificacao> getCerfiticacoes(Curriculo curriculo){
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();
		
		String jpql = "Select c from Certificacao c join c.curriculos cu where cu = :pCurriculo";
		Query query = em.createQuery(jpql);
		query.setParameter("pCurriculo", curriculo);
		// persiste o objeto
		List<Certificacao> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
}
