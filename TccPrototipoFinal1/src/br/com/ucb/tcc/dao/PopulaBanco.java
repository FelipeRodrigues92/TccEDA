package br.com.ucb.tcc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.NivelCurso;
import br.com.ucb.tcc.bean.ConteudistaBean;
import br.com.ucb.tcc.dao.JPAUtil;
import br.com.ucb.tcc.modelo.Autor;
import br.com.ucb.tcc.modelo.Certificacao;
import br.com.ucb.tcc.modelo.Livro;

public class PopulaBanco {

	public static void main(String[] args) {

			// TODO Auto-generated method stub
			NivelCurso tecnologo = new NivelCurso();
			tecnologo.setTipo("Tecnólogo");
			tecnologo.setDescricacao(" ");
			
			NivelCurso graduacao = new NivelCurso();
			graduacao.setTipo("Graduação");
			graduacao.setDescricacao(" ");
			
			NivelCurso posgraduacao = new NivelCurso();
			posgraduacao.setTipo("Pós-Graduação");
			posgraduacao.setDescricacao(" ");
			
			NivelCurso mestrado = new NivelCurso();
			mestrado.setTipo("Mestrado");
			mestrado.setDescricacao(" ");
			
			NivelCurso doutorado = new NivelCurso();
			doutorado.setTipo("Doutorado");
			doutorado.setDescricacao(" ");

			NivelCurso posdoutorado = new NivelCurso();
			posdoutorado.setTipo("Pós-Doutorado");
			posdoutorado.setDescricacao(" ");
			
			Conteudista cont = new Conteudista();
			cont.setCPF("1123213123");
			cont.setNome("testando");
			
//			
			
//			Endereco endereco = new Endereco();
//			endereco.setBairro("Leste");
//			endereco.setCidade("Gama");
//			endereco.setComplemento("33");
//			endereco.setUF(UnidadeFederacao.DF);
//			endereco.setCep("23345765");
//			
//			Conteudista conteudista = new Conteudista();
//			conteudista.setCPF("12312312312");
//			conteudista.setEmail("tabeco");
//			conteudista.setEndereco(endereco);
//			
	//
			Conteudista conteudista2 = new Conteudista();
			conteudista2.setCPF("123123123444");
			conteudista2.setEmail("tabedc");
			
			ConteudistaBean conteBean = new ConteudistaBean();
			conteBean.setConteudista(conteudista2);
			
//			conteBean.gravar();
//			
//			endereco.setUsuarios(Arrays.asList(conteudista, conteudista2));
//			EntityManager em = new JPAUtil().getEntityManager();
			
//			em.getTransaction().begin();
//			em.persist(tecnologo);
//			em.persist(graduacao);
//			em.persist(posgraduacao);
//			em.persist(mestrado);
//			em.persist(doutorado);
//			em.persist(posdoutorado);
			
//			em.persist(conteudista2);
//			em.persist(conteudista);
//			em.persist(endereco);
//			
//			em.getTransaction().commit();
//			em.getTransaction().begin();
//			Endereco end = em.find(Endereco.class, 1);
	//
//			Conteudista cond = em.find(Conteudista.class, 2);
//			end.setUsuarios(Arrays.asList(cond, conteudista));
//			em.getTransaction().commit();
			
			Curriculo curriculo = new DAO<Curriculo>(Curriculo.class).buscaPorId(1);
			List<Certificacao> resultados = new ArrayList<Certificacao>();
//			EntityManager em = new JPAUtil().getEntityManager();
//
//			// abre transacao
//			em.getTransaction().begin();
//			
//			String jpql = "Select c from Curso c where c.curriculo = :pCurriculo";
//			Query query = em.createQuery(jpql);
//			query.setParameter("pCurriculo", curriculo);
//			// persiste o objeto
//			resultados = query.getResultList();
//			// commita a transacao
//			em.getTransaction().commit();
//
//			// fecha a entity manager
//			em.close();
//			System.out.println("opaa");
//			//System.out.println(end.getUsuarios().size());
//			em.close();
		
			EntityManager em = new JPAUtil().getEntityManager();

			// abre transacao
			em.getTransaction().begin();
			
			String jpql = "Select c from Certificacao c join c.curriculos cu where cu = :pCurriculo";
			Query query = em.createQuery(jpql);
			query.setParameter("pCurriculo", curriculo);
			// persiste o objeto
			resultados = query.getResultList();
			// commita a transacao
			em.getTransaction().commit();

			// fecha a entity manager
			em.close();
		
		
			for(int i= 0; i < resultados.size(); i++ ) {
				System.out.println(resultados.get(i).getNome());
				
			}
		}



}
