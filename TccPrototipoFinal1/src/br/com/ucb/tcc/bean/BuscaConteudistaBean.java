package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucb.tcc.dao.ConteudoAptoDAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.ConteudoApto;

@ManagedBean
public class BuscaConteudistaBean {
	private String desdobramento = "";

	public String getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(String desdobramento) {
		this.desdobramento = desdobramento;
	}
	
	public List<Conteudista> getConteudistas(){
		String desdobramento = getDesdobramento();
		if(desdobramento == null){
			desdobramento="chamander";
		}
		List<ConteudoApto> conteudosAptos = new ConteudoAptoDAO().getConteudoPorDesdobramento(desdobramento); 
		List<ConteudoApto> conteudosAptoID = new ArrayList<ConteudoApto>();
		
		for (ConteudoApto conteudoApto : conteudosAptos) {
			System.out.println(conteudosAptos.size()+" tamanho");
			System.out.println(conteudoApto.getId());
		}
		System.out.println("view");
		return null;
		
	}
}
