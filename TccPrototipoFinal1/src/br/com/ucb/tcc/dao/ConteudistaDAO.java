package br.com.ucb.tcc.dao;

import javax.persistence.EntityManager;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.dao.JPAUtil;

public class ConteudistaDAO {
	public void gravar(Conteudista conteudista, Endereco endereco, Curriculo curriculo) {
	EntityManager em = new JPAUtil().getEntityManager();

	// abre transacao
	em.getTransaction().begin();

	// persiste o objeto
	em.persist(conteudista);
	em.persist(endereco);
	em.persist(curriculo);
	// commita a transacao
	em.getTransaction().commit();

	// fecha a entity manager
	em.close();
	}
}
