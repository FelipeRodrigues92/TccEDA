package br.com.ucb.tcc.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sun.faces.facelets.tag.jstl.core.ForEachHandler;
import com.sun.javafx.collections.ArrayListenerHelper;

import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Conteudo;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Curso;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.modelo.Gestor;
import br.com.ucb.tcc.modelo.NivelCurso;
import br.com.ucb.tcc.modelo.Sexo;
import br.com.ucb.tcc.modelo.SubGestor;
import br.com.ucb.tcc.modelo.UnidadeFederacao;
import br.com.ucb.tcc.modelo.Usuario;
import br.com.ucb.tcc.bean.ConteudistaBean;
import br.com.ucb.tcc.dao.JPAUtil;
import br.com.ucb.tcc.modelo.Area;
import br.com.ucb.tcc.modelo.BancoCurso;
import br.com.ucb.tcc.modelo.BuscaEmConteudo;
import br.com.ucb.tcc.modelo.Certificacao;

public class PopulaBanco {

	public static void main(String[] args) {
////
//		// TODO Auto-generated method stub
//
//		NivelCurso graduacao = new NivelCurso();
//		graduacao.setTipo("Graduação");
//		graduacao.setDescricacao(" ");
//
//		NivelCurso posgraduacao = new NivelCurso();
//		posgraduacao.setTipo("Pós-Graduação");
//		posgraduacao.setDescricacao(" ");
//
//		NivelCurso mestrado = new NivelCurso();
//		mestrado.setTipo("Mestrado");
//		mestrado.setDescricacao(" ");
//
//		NivelCurso doutorado = new NivelCurso();
//		doutorado.setTipo("Doutorado");
//		doutorado.setDescricacao(" ");
//
//		NivelCurso posdoutorado = new NivelCurso();
//		posdoutorado.setTipo("Pós-Doutorado");
//		posdoutorado.setDescricacao(" ");
//
//		BancoCurso bancoCurso = new BancoCurso();
//		bancoCurso.setNome("TECNOLOGIA EM ARTILHARIA");
//		bancoCurso.setArea(Area.MILITAR);
//		
//		BancoCurso bancoCurso2 = new BancoCurso();
//		bancoCurso2.setNome("TECNOLOGIA EM SISTEMAS DE NAVEGAÇÃO FLUVIAL ");
//		bancoCurso2.setArea(Area.INFRAESTRUTURA);
//		
//		BancoCurso bancoCurso3 = new BancoCurso();
//		bancoCurso3.setNome("TECNOLOGIA EM GEOPROCESSAMENTO");
//		bancoCurso3.setArea(Area.INFRAESTRUTURA);
//		
//		BancoCurso bancoCurso4 = new BancoCurso();
//		bancoCurso4.setNome("TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");
//		bancoCurso4.setArea(Area.INFORMACAO_COMUNICACAO);
//
//		BancoCurso bancoCurso5 = new BancoCurso();
//		bancoCurso5.setNome("TECNOLOGIA EM BANCO DE DADOS");
//		bancoCurso5.setArea(Area.INFORMACAO_COMUNICACAO);
//
//		BancoCurso bancoCurso6 = new BancoCurso();
//		bancoCurso6.setNome("TECNOLOGIA EM GESTÃO DA TECNOLOGIA DA INFORMAÇÃO");
//		bancoCurso6.setArea(Area.INFORMACAO_COMUNICACAO);
//		
//		BancoCurso bancoCurso7 = new BancoCurso();
//		bancoCurso7.setNome("TECNOLOGIA EM REDES DE COMPUTADORES");
//		bancoCurso7.setArea(Area.INFORMACAO_COMUNICACAO);
//		
//		BancoCurso bancoCurso8 = new BancoCurso();
//		bancoCurso8.setNome("CURSO SUPERIOR SISTEMAS DE INFORMAÇÃO");
//		bancoCurso8.setArea(Area.INFORMACAO_COMUNICACAO);
//		
//		BancoCurso bancoCurso9 = new BancoCurso();
//		bancoCurso9.setNome("TECNOLOGIA EM JOGOS DIGITAIS");
//		bancoCurso9.setArea(Area.INFORMACAO_COMUNICACAO);
//		
//		 Endereco endereco = new Endereco();
//		 endereco.setBairro("Leste");
//		 endereco.setCidade("Gama");
//		 endereco.setComplemento("33");
//		 endereco.setUF(UnidadeFederacao.DF);
//		 endereco.setCep("23345765");
//		
//		 
//		 
//		 Conteudista conteudista = new Conteudista();
//		 conteudista.setCPF("11111111111");
//		 conteudista.setNome("Felipe");
//		 conteudista.setEmail("123@gmail.com");
//		 conteudista.setEndereco(endereco);
//		 conteudista.setSenha("123");
//		 conteudista.setSexo(Sexo.MASCULINO);
//		 conteudista.setTelefone("5434543234");
//		
//		 Curriculo curriculo = new  Curriculo();
//		 curriculo.setConteudista(conteudista);
//		
//		SubGestor subGestor = new SubGestor();
//		subGestor.setCPF("123123123444");
//		subGestor.setNome("SubADM");
//		subGestor.setEmail("subadm@gmail.com");
//		subGestor.setSenha("123");
//		subGestor.setSexo(Sexo.MASCULINO);
//		subGestor.setTelefone("5434543234");
//
//		Gestor gestor = new Gestor();
//		gestor.setCPF("123123123444");
//		gestor.setNome("ADM");
//		gestor.setEmail("adm@gmail.com");
//		gestor.setSenha("123");
//		gestor.setSexo(Sexo.MASCULINO);
//		gestor.setTelefone("5434543234");
//		
//		Conteudo conteudo = new Conteudo();
//		conteudo.setTitulo("Myfile");
//		conteudo.setDescricao("");
//		conteudo.setAvaliacao(10);
//		conteudo.setSubGestor(subGestor);
//		conteudo.setConteudista(conteudista);
//
//		Conteudo conteudo2 = new Conteudo();
//		conteudo2.setTitulo("Myfile2");
//		conteudo2.setDescricao("");
//		conteudo2.setAvaliacao(9);
//		conteudo2.setSubGestor(subGestor);
//		conteudo2.setConteudista(conteudista);
//		//ConteudistaBean conteBean = new ConteudistaBean();
//		//conteBean.setConteudista(conteudista2);
//
//		// conteBean.gravar();
//		//
//		// endereco.setUsuarios(Arrays.asList(conteudista, conteudista2));
//		 EntityManager em = new JPAUtil().getEntityManager();
//
//		 em.getTransaction().begin();
//		 
//		 em.persist(graduacao);
//		 em.persist(posgraduacao);
//		 em.persist(mestrado);
//		 em.persist(doutorado);
//		 em.persist(posdoutorado);
//		 em.persist(endereco);
//		 em.persist(gestor);
//		 em.persist(subGestor);
//		 em.persist(conteudista);
//		 em.persist(curriculo);
//		 em.persist(conteudo);
//		 em.persist(conteudo2);
//		 em.persist(bancoCurso);
//		 em.persist(bancoCurso2);
//		 em.persist(bancoCurso3);
//		 em.persist(bancoCurso4);
//		 em.persist(bancoCurso5);
//		 em.persist(bancoCurso6);
//		 em.persist(bancoCurso7);
//		 em.persist(bancoCurso8);
//		 em.persist(bancoCurso9);
////		 
//		// em.persist(conteudista2);
//		// em.persist(conteudista);
//		// em.persist(endereco);
//		//
//		 em.getTransaction().commit();
//		 em.getTransaction().begin();
//		 em.close();
//	
//		 
//		 List<String> paths = new ArrayList<String>();
//		 File[] files = listDir( new File("/Users/feliperodrigues/Documents/tcc2"));
//		 for (File file : files) {
//			 System.out.println(file.getPath().toString());
//			 paths.add(file.getPath());
//		}
//	}	 
//	public static File[] listDir(File dir) {
//		Vector enc = new Vector();
//		File[] files = dir.listFiles();
//		List<String> diretorios = new ArrayList<String>();
//		for (int i = 0; i < files.length; i++) {
//			if (files[i].isDirectory()) {
//				//Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
//				File[] recFiles = listDir(files[i]);
//				for (int j = 0; j < recFiles.length; j++) {
//						enc.addElement(recFiles[j]);
//				}
//			} else {
//				//Adiciona no Vector o arquivo encontrado dentro de 'dir':
//				if(files[i].getName().endsWith(".html")) {
//					//System.out.println(files[i].toString());
//					enc.addElement(files[i]);
//				}
//			}
//		}
//		//Transforma um Vector em um File[]:
//		File[] encontrados = new File[enc.size()];
//		for (int i = 0; i < enc.size(); i++) {
//			encontrados[i] = (File)enc.elementAt(i);
//		}
//		return encontrados;
		List<Integer> resultados = new ArrayList<Integer>();
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		String jpql = "Select distinct d.id from ConteudoApto ca join ca.desdobramentos d where ca = 2";
		Query query = em.createQuery(jpql);
		//query.setParameter("pConteudoId", conteudoId);
		// persiste o objeto
		resultados = query.getResultList();
		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
		for (Integer integer : resultados) {
			System.out.println(integer);
		}

	}
}
