package br.com.ucb.tcc.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.ucb.tcc.modelo.BuscaEmConteudo;
import br.com.ucb.tcc.modelo.Conteudo;

@ManagedBean
@RequestScoped
public class BuscaConteudoBean {
	private String palavraBuscada;
	
	public String getPalavraBuscada() {
		return palavraBuscada;
	}

	public void setPalavraBuscada(String palavraBuscada) {
		this.palavraBuscada = palavraBuscada;
	}

	public List<BuscaEmConteudo> getConteudosComString(){
		String palavraBuscada = getPalavraBuscada();
		if(palavraBuscada == null){
			palavraBuscada="";
		}
		List<BuscaEmConteudo> conteudosTitulos = new ArrayList<BuscaEmConteudo>();
		List<BuscaEmConteudo> conteudosPalavras = new ArrayList<BuscaEmConteudo>();
		List<String> arquivosNomes = new ArrayList<String>();
		List<BuscaEmConteudo> listaFinal = new ArrayList<BuscaEmConteudo>();
		Integer palavras = 0;
		String str;
		int encontrado;
		int bloco = 1;
		String fazTitulo = "";
		String fazPalavra = "";
		int totalBloco = 0;
		String nomeArquivo = "Myfiles.html";
		arquivosNomes.add("Myfile");
		arquivosNomes.add("Myfile2");

		for (int j = 0; j < arquivosNomes.size(); j++) {
			encontrado = 0;
			List<String> tituloAchado = new ArrayList<String>();
			List<String> titulos = new ArrayList<String>();
			try {
				BufferedReader in = new BufferedReader(new FileReader("C:/doc/" + arquivosNomes.get(j) + ".html")); // declara
																												// o
																												// nome
																												// do
																												// arquivo

				while ((str = in.readLine()) != null) { // vasculha todo o arquivo e armazena os dados encontrado na
														// variável "str"

					for (int i = 0; i < str.length(); i++) {
						Character caractere = str.charAt(i); // Aqui a estring é diluida, ou seja, os caractere do
																// arquivo
																// serão jogados em vetores, para possível maniplação.

						fazTitulo = fazTitulo + caractere;// aqui eu criei blocos de palavras
						fazPalavra = fazPalavra + caractere;

						if (fazPalavra.contains(palavraBuscada)) {
							encontrado++; // que será uma espécie de contagem de quantos blocos há dentro do
							fazPalavra = "";
						}

						if (fazTitulo.contains("<h1>")) {

							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h1>")) {

							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							titulos.add(fazTitulo);
							fazTitulo = ""; // O bloco é zerado para não ficar um bloco acumuladtivo
						}

					}
				}

				in.close();
			} catch (IOException e) {
				System.out.println("Há a possibilidade de um arquivo com nome diferente ao regristro no banco."); // possiveis
																													// erros
																													// são
																													// tratatos
																													// aqui
			}
			BuscaEmConteudo conteudo = new BuscaEmConteudo();
			conteudo.setNomeArquivo(arquivosNomes.get(j));
			conteudo.setQtdParalavras(encontrado);
			if (titulos.size() > 0) {
				// System.out.println(titulos.size());
				Boolean inserirEmTitulos = false;
				for (int i = 0; i < titulos.size(); i++) {
					
					if (titulos.get(i).toUpperCase().contains(palavraBuscada.toUpperCase())) {
						inserirEmTitulos = true;
						tituloAchado.add(titulos.get(i));
						conteudo.setTitulo(tituloAchado);
					}
				}
				if (inserirEmTitulos == true) {
					conteudosTitulos.add(conteudo);
				} else if ((inserirEmTitulos == false) && (encontrado > 0)) {
					conteudosPalavras.add(conteudo);
				}
			}
			// System.exit(0);
			listaFinal = conteudosTitulos;
			for (int i = 0; i < conteudosPalavras.size(); i++) {

				listaFinal.add(conteudosPalavras.get(i));

			}
			// System.out.println(conteudosPalavras.size());
			// System.out.println(listaFinal.size());
			if(j == arquivosNomes.size()-1) {
			for (int i = 0; i < listaFinal.size(); i++) {
				System.out.println(listaFinal.get(i).getNomeArquivo());
				System.out.println(listaFinal.get(i).getTitulo());
				System.out.println(listaFinal.get(i).getQtdParalavras());
			}
			}

		}
		return listaFinal;
	}

}

