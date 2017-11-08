package br.com.ucb.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Conteudo;
import br.com.ucb.tcc.modelo.ConteudoApto;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Desdobramento;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.modelo.Usuario;

public class ConteudoAptoDAO {
	public void gravar(ConteudoApto conteudoApto) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		// persiste o objeto
		for (int i = 0; i < 5; i++) {
			em.persist(conteudoApto.getDesdobramentos().get(i));
		}
		em.persist(conteudoApto);
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}

	public Curriculo getCurriculoCursoConteudo(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct cr from Curriculo cr join cr.cursos cu join cu.conteudosAptos c where c.id = :pId";
		Query query = em.createQuery(jpql);
		query.setParameter("pId", id);
		// persiste o objeto
		List<Curriculo> resultado = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);

	}

	public Curriculo getCurriculoCertificacaoConteudo(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		// "Select distinct cr from Curriculo cr join cr.certificacoes ce join
		// ce.conteudosAptos c where c.id = :pId";
		// "Select distinct ce from Certificacao ce join ce.conteudosAptos ca where
		// ca.id = :pId";
		String jpql = "Select distinct cr from Curriculo cr join cr.certificacoes ce join ce.conteudosAptos c where c.id = :pId";
		Query query = em.createQuery(jpql);
		query.setParameter("pId", id);
		// persiste o objetov
		List<Curriculo> resultado = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get(0);
	}

	public List<ConteudoApto> getConteudoPorDesdobramento(String desdobramento) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct ca from ConteudoApto ca join ca.desdobramentos d where d.descricao like :pDesdobramento";
		Query query = em.createQuery(jpql);
		query.setParameter("pDesdobramento", "%" + desdobramento + "%");
		// persiste o objeto
		List<ConteudoApto> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
	public List<ConteudoApto> getConteudoCom(String conteudoNome) {
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct ca from ConteudoApto ca join ca.desdobramentos d where ca.titulo like :pConteudoNome";
		Query query = em.createQuery(jpql);
		query.setParameter("pConteudoNome", "%" + conteudoNome + "%");
		// persiste o objeto
		List<ConteudoApto> resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		return resultados;
	}
}
