package br.com.ucb.tcc.modelo;

import java.util.List;

public class BuscaEmConteudo {
	private String nomeArquivo;
	private List<String> Titulo;
	private Integer QtdParalavras;
	
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
		return QtdParalavras;
	}
	public void setQtdParalavras(Integer qtdParalavras) {
		QtdParalavras = qtdParalavras;
	}

	
}
