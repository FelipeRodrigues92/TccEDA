package br.com.ucb.tcc.dao;

import javax.persistence.EntityManager;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Conteudo;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Desdobramento;
import br.com.ucb.tcc.modelo.Endereco;

public class ConteudoAptoDAO {
	public void gravar(ConteudoApto conteudoApto) {
	EntityManager em = new JPAUtil().getEntityManager();

	// abre transacao
	em.getTransaction().begin();

	// persiste o objeto
	for(int i = 0; i <5; i++) {
		em.persist(conteudoApto.getDesdobramentos().get(i));
	}
	em.persist(conteudoApto);
	// commita a transacao
	em.getTransaction().commit();

	// fecha a entity manager
	em.close();
	}
}
