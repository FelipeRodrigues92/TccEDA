package br.com.ucb.tcc.modelo;

import java.util.Comparator;
import java.util.List;

public class BuscaEmConteudo implements Comparator<BuscaEmConteudo> {
	private String nomeArquivo;
	private List<String> h1;
	private List<String> h2;
	private List<String> h3;
	private List<String> h4;
	private List<String> h5;
	private int contadorH1;
	private int contadorH2;
	private int contadorH3;
	private int contadorH4;
	private int contadorH5;
	public int getContadorH1() {
		return contadorH1;
	}
	public void setContadorH1(int contadorH1) {
		this.contadorH1 = contadorH1;
	}
	public int getContadorH2() {
		return contadorH2;
	}
	public void setContadorH2(int contadorH2) {
		this.contadorH2 = contadorH2;
	}
	public int getContadorH3() {
		return contadorH3;
	}
	public void setContadorH3(int contadorH3) {
		this.contadorH3 = contadorH3;
	}
	public int getContadorH4() {
		return contadorH4;
	}
	public void setContadorH4(int contadorH4) {
		this.contadorH4 = contadorH4;
	}
	public int getContadorH5() {
		return contadorH5;
	}
	public void setContadorH5(int contadorH5) {
		this.contadorH5 = contadorH5;
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
	private Integer qtdParalavras;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public Integer getQtdParalavras() {
		return qtdParalavras;
	}
	public void setQtdParalavras(Integer qtdParalavras) {
		this.qtdParalavras = qtdParalavras;
	}

	@Override
	public int compare(BuscaEmConteudo o1, BuscaEmConteudo o2) {
		int nomeComparacao = o1.compareTo(o2.contadorH1); // compara nome
		if (nomeComparacao != 0){
			return nomeComparacao;
		}
		return nomeComparacao; 
	}
	private int compareTo(Integer o2) {
		int valor = this.compareTo(o2.contadorH1) * -1;
		 if (this.getContadorH1() > outraBusca.getContadorH1()) {
	          return -1;
	     }
	     if (this.getH1().size() > outraBusca.getH1().size()) {
	          return 1;
	     }
	     return 0;
	}
}
