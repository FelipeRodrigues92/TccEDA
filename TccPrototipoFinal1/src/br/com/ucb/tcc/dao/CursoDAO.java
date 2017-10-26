package br.com.ucb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;

public class CursoDAO {	
	
	public List<Curso> getCursos(Curriculo curriculo){
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();
		
		String jpql = "Select c from Curso c where c.curriculo = :pCurriculo";
		Query query = em.createQuery(jpql);
		query.setParameter("pCurriculo", curriculo);
		// persiste o objeto
		List<Curso> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
}
