package br.com.ucb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;

public class CurriculoDAO {
	public Curriculo getCurriculoPorUserId(Integer usuarioId){
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();
		
		String jpql = "Select c from Curriculo c join c.conteudista u where u.id = :pUsuarioId";
		Query query = em.createQuery(jpql);
		query.setParameter("pUsuarioId", usuarioId);
		// persiste o objeto
		Curriculo resultados = (Curriculo) query.getSingleResult();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
	public Conteudista getUserPorCurriculo(Integer curriculoId){
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();
		
		String jpql = "Select u from Curriculo c join c.conteudista u where c.id = :pCurriculoId";
		Query query = em.createQuery(jpql);
		query.setParameter("pCurriculoId", curriculoId);
		// persiste o objeto
		List<Conteudista> resultados =  query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		if (resultados.isEmpty()) {
			return null;
		}
		return resultados.get(0);

	}
}
