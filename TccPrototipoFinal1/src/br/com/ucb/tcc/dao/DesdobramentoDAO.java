package br.com.ucb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.ConteudoApto;

public class DesdobramentoDAO {
	public List<Integer> getDesdobramentoIdPorConteudo(Integer conteudoId) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct d.id from ConteudoApto ca join ca.desdobramentos d where ca = :pConteudoId";
		Query query = em.createQuery(jpql);
		query.setParameter("pConteudoId", conteudoId);
		// persiste o objeto
		List<Integer> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
	public List<String> getDesdobramentoDescricaoPorConteudo(Integer conteudoId) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct d.descricao from ConteudoApto ca join ca.desdobramentos d where ca.id = :pConteudoId";
		Query query = em.createQuery(jpql);
		query.setParameter("pConteudoId", conteudoId);
		// persiste o objeto
		List<String> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
}
