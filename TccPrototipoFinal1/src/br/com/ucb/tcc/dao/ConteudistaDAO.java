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
		
		public void atualiza(Conteudista conteudista, Endereco endereco) {
			
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		System.out.println("endereco" + endereco.getId());
		System.out.println("conteudista " + conteudista.getId());
		em.merge(endereco);
		System.out.println("endereco" + endereco.getId());
		System.out.println("conteudista " + conteudista.getId());
		em.merge(conteudista);
		System.out.println("endereco" + endereco.getId());
		System.out.println("conteudista " + conteudista.getId());
		em.getTransaction().commit();
		em.close();
		}
	}
