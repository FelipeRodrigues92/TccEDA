package br.com.tcc.popula;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc.modelo.Conteudista;
import br.com.tcc.modelo.Endereco;
import br.com.tcc.modelo.NivelCurso;
import br.com.tcc.modelo.UnidadeFederacao;
import br.com.tcc.util.JPAUtil;

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
		
		
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Leste");
		endereco.setCidade("Gama");
		endereco.setComplemento("33");
		endereco.setUF(UnidadeFederacao.DF);
		endereco.setCep("23345765");
		
		Conteudista conteudista = new Conteudista();
		conteudista.setCPF("12312312312");
		conteudista.setEmail("tabeco");
		conteudista.setEndereco(endereco);
		endereco.setUsuarios(Arrays.asList(conteudista));
		EntityManager em = new JPAUtil().getEntityManager();
		
//		em.getTransaction().begin();
//		em.persist(tecnologo);
//		em.persist(graduacao);
//		em.persist(posgraduacao);
//		em.persist(mestrado);
//		em.persist(doutorado);
//		em.persist(posdoutorado);
//		
//		em.persist(conteudista);
//		em.persist(endereco);
//		
//		em.getTransaction().commit();
		em.getTransaction().begin();
		Endereco end = em.find(Endereco.class, 1);

		Conteudista cond = em.find(Conteudista.class, 2);
		end.setUsuarios(Arrays.asList(cond, conteudista));
		em.getTransaction().commit();
		
		System.out.println("opaa");
		System.out.println(end.getUsuarios().size());
		em.close();
	}

}
