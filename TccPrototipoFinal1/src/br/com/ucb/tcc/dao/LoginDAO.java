package br.com.ucb.tcc.dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.modelo.Usuario;

public class LoginDAO {
	public boolean existe(Login login) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		String jpql = "select u from Usuario u where u.email = :pEmail and u.senha = :pSenha";
		Query query = em.createQuery(jpql);
		query.setParameter("pEmail", login.getEmail());
		query.setParameter("pSenha", login.getSenha());
		List<Usuario> resultados = query.getResultList();
		em.close(); 
		
		if(resultados.size()>0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioId", resultados.get(0).getId());
			return true;
		}
		
		return false;
	}
}
