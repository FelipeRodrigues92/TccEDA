package br.com.ucb.tcc.modelo;

import java.util.Comparator;
import java.util.List;

public class BuscaEmConteudo implements Comparable<BuscaEmConteudo> {
	
	
	private String nomeArquivo;
	private String diretorio;
	public String getDiretorio() {
		return diretorio;
	}


	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	private List<String> h1;
	private List<String> h2;
	private List<String> h3;
	private List<String> h4;
	private List<String> h5;
	private String contadorH1;
	private String contadorH2;
	private String contadorH3;
	private String contadorH4;
	private String contadorH5;


	public String getNomeArquivo() {
		return nomeArquivo;
	}


	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public List<String> getH1() {
		return h1;
	}


	public void setH1(List<String> h1) {
		this.h1 = h1;
	}


	public List<String> getH2() {
		return h2;
	}


	public void setH2(List<String> h2) {
		this.h2 = h2;
	}


	public List<String> getH3() {
		return h3;
	}


	public void setH3(List<String> h3) {
		this.h3 = h3;
	}


	public List<String> getH4() {
		return h4;
	}


	public void setH4(List<String> h4) {
		this.h4 = h4;
	}


	public List<String> getH5() {
		return h5;
	}


	public void setH5(List<String> h5) {
		this.h5 = h5;
	}


	public String getContadorH1() {
		return contadorH1;
	}


	public void setContadorH1(String contadorH1) {
		this.contadorH1 = contadorH1;
	}


	public String getContadorH2() {
		return contadorH2;
	}


	public void setContadorH2(String contadorH2) {
		this.contadorH2 = contadorH2;
	}


	public String getContadorH3() {
		return contadorH3;
	}


	public void setContadorH3(String contadorH3) {
		this.contadorH3 = contadorH3;
	}


	public String getContadorH4() {
		return contadorH4;
	}


	public void setContadorH4(String contadorH4) {
		this.contadorH4 = contadorH4;
	}


	public String getContadorH5() {
		return contadorH5;
	}


	public void setContadorH5(String contadorH5) {
		this.contadorH5 = contadorH5;
	}
	
	public int getRelevanciaH1() {
		if(this.h1.isEmpty()) {
			return 0;
		}
		return 100;
	}
	public int getRelevanciaH2() {
		if(this.h2.isEmpty()) {
			return 0;
		}
		return 50;
	}
	public int getRelevanciaH3() {
		if(this.h3.isEmpty()) {
			return 0;
		}
		return 30;
	}

	@Override
	public int compareTo(BuscaEmConteudo outroConteudo) {
		int comparaH1 = this.contadorH1.compareTo(outroConteudo.contadorH1) * -1;
		if (comparaH1 == 0) {
			return this.contadorH2.compareTo(outroConteudo.contadorH2);
		}
		return comparaH1;
	}
//	@Override
//	public int compare(BuscaEmConteudo o1, BuscaEmConteudo o2) {
//		int nomeComparacao = o1.compareTo(o2, 1); // compara nome
//		if (nomeComparacao == 0) {
//			return o1.compareTo(o2, 2);
//		}
//		return nomeComparacao;
//	}
	
}
