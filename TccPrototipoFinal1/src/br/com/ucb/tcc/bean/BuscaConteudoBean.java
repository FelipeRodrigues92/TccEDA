package br.com.ucb.tcc.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.BuscaEmConteudo;
import br.com.ucb.tcc.modelo.Conteudo;

@ManagedBean
@ViewScoped
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
			palavraBuscada="   ";
		}
		List<BuscaEmConteudo> listaFinal = new ArrayList<BuscaEmConteudo>();
		List<BuscaEmConteudo> conteudosTitulos = new ArrayList<BuscaEmConteudo>();
		List<BuscaEmConteudo> conteudosPalavras = new ArrayList<BuscaEmConteudo>();
		String str;
		int encontrado;
		String fazTitulo = "";
		String fazPalavra = "";
		
		 File[] files = listDir( new File("/Users/feliperodrigues/Documents/tcc2"));

		
		for (File file : files) {
			encontrado = 0;
			List<String> tituloAchado = new ArrayList<String>();
			List<String> titulos = new ArrayList<String>();
			try {
				BufferedReader in = new BufferedReader(new FileReader(file.getPath().toString())); // declara

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
			conteudo.setNomeArquivo(file.getName());
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
		}
		return listaFinal;
	}

	private File[] listDir(File dir) {
		Vector enc = new Vector();
		File[] files = dir.listFiles();
		List<String> diretorios = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				//Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
				File[] recFiles = listDir(files[i]);
				for (int j = 0; j < recFiles.length; j++) {
						enc.addElement(recFiles[j]);
				}
			} else {
				//Adiciona no Vector o arquivo encontrado dentro de 'dir':
				if(files[i].getName().endsWith(".html")) {
					//System.out.println(files[i].toString());
					enc.addElement(files[i]);
				}
			}
		}
		//Transforma um Vector em um File[]:
		File[] encontrados = new File[enc.size()];
		for (int i = 0; i < enc.size(); i++) {
			encontrados[i] = (File)enc.elementAt(i);
		}
		return encontrados;
	}
	

}

