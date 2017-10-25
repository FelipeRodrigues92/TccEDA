package br.com.ucb.tcc.modelo;

import java.util.List;

public class BuscaEmConteudo {
	private String nomeArquivo;
	private List<String> Titulo;
	private Integer qtdParalavras;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public List<String> getTitulo() {
		return Titulo;
	}
	public void setTitulo(List<String> titulo) {
		Titulo = titulo;
	}
	public Integer getQtdParalavras() {
		return qtdParalavras;
	}
	public void setQtdParalavras(Integer qtdParalavras) {
		this.qtdParalavras = qtdParalavras;
	}
	
	
}
