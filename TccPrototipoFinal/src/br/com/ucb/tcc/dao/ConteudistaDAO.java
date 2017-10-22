package br.com.ucb.tcc.dao;

import javax.persistence.EntityManager;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.dao.JPAUtil;

public class ConteudistaDAO {
	public void gravar(Conteudista conteudista) {
	EntityManager em = new JPAUtil().getEntityManager();

	// abre transacao
	em.getTransaction().begin();

	// persiste o objeto
	em.persist(conteudista);

	// commita a transacao
	em.getTransaction().commit();

	// fecha a entity manager
	em.close();
	}
}
