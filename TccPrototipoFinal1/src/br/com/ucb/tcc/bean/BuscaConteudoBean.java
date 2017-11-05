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

	public List<BuscaEmConteudo> getConteudosComString() {
		String palavraBuscada = getPalavraBuscada();
		if (palavraBuscada == null) {
			palavraBuscada = "   ";
		}
		List<BuscaEmConteudo> listaFinal = new ArrayList<BuscaEmConteudo>();
		List<BuscaEmConteudo> conteudosTitulos = new ArrayList<BuscaEmConteudo>();
		List<BuscaEmConteudo> conteudosPalavras = new ArrayList<BuscaEmConteudo>();
		String str;
		int encontrado;
		String fazTitulo = "";
		String fazPalavra = "";

		File[] files = listDir(new File("/Users/feliperodrigues/Documents/tcc2"));

		for (File file : files) {
			encontrado = 0;
			List<String> h1 = new ArrayList<String>();
			List<String> h2 = new ArrayList<String>();
			List<String> h3 = new ArrayList<String>();
			List<String> h4 = new ArrayList<String>();
			List<String> h5 = new ArrayList<String>();
			Integer contH1 = 0;
			Integer contH2 = 0;
			Integer contH3 = 0;
			Integer contH4 = 0;
			Integer contH5 = 0;
			try {
				BufferedReader in = new BufferedReader(new FileReader(file.getPath().toString()));

				while ((str = in.readLine()) != null) {

					for (int i = 0; i < str.length(); i++) {
						Character caractere = str.charAt(i);

						fazTitulo = fazTitulo + caractere;
						fazPalavra = fazPalavra + caractere;
						if (fazPalavra.contains(palavraBuscada)) {
							encontrado++;
							fazPalavra = "";
						}
						if (fazTitulo.contains("<h1>")) {
							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h1>")) {
							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							if (fazTitulo.toUpperCase().contains(palavraBuscada.toUpperCase())) {
								h1.add(fazTitulo);
								contH1++;
							}
							fazTitulo = "";
						}
						if (fazTitulo.contains("<h2>")) {
							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h2>")) {
							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							if (fazTitulo.toUpperCase().contains(palavraBuscada.toUpperCase())) {
								h2.add(fazTitulo);
								contH2++;
							}
							fazTitulo = "";
						}
						if (fazTitulo.contains("<h3>")) {
							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h3>")) {
							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							if (fazTitulo.toUpperCase().contains(palavraBuscada.toUpperCase())) {
								h3.add(fazTitulo);
								contH3++;
							}
							fazTitulo = "";
						}
						if (fazTitulo.contains("<h4>")) {
							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h4>")) {
							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							if (fazTitulo.toUpperCase().contains(palavraBuscada.toUpperCase())) {
								h4.add(fazTitulo);
								contH4++;
							}
							fazTitulo = "";
						}
						if (fazTitulo.contains("<h5>")) {
							fazTitulo = "";
						} // arquivo.
						if (fazTitulo.contains("</h5>")) {
							fazTitulo = fazTitulo.substring(0, fazTitulo.length() - 5);
							if (fazTitulo.toUpperCase().contains(palavraBuscada.toUpperCase())) {
								h5.add(fazTitulo);
								contH5++;
							}
							fazTitulo = "";
						}
					}
				}
				in.close();
			} catch (IOException e) {
				System.out.println("Há a possibilidade de um arquivo com nome diferente ao regristro no banco.");
			}

			BuscaEmConteudo conteudo = new BuscaEmConteudo();
			conteudo.setNomeArquivo(file.getName());
			conteudo.setQtdParalavras(encontrado);
			boolean inserirEmTitulos = false;
			if (h1.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH1(h1);
				conteudo.setContadorH1(contH1);
				inserirEmTitulos = true;
			}
			if (h2.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH2(h2);
				conteudo.setContadorH2(contH2);
				inserirEmTitulos = true;
			}
			if (h2.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH3(h3);
				inserirEmTitulos = true;
			}
			if (h3.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH3(h3);
				inserirEmTitulos = true;
			}
			if (h4.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH4(h4);
				inserirEmTitulos = true;
			}
			if (h5.size() > 0) {
				// System.out.println(titulos.size());
				conteudo.setH5(h5);
				inserirEmTitulos = true;
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
	return listaFinal;

	}

	private File[] listDir(File dir) {
		Vector enc = new Vector();
		File[] files = dir.listFiles();
		List<String> diretorios = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				// Adiciona no Vector os arquivos encontrados dentro de 'files[i]':
				File[] recFiles = listDir(files[i]);
				for (int j = 0; j < recFiles.length; j++) {
					enc.addElement(recFiles[j]);
				}
			} else {
				// Adiciona no Vector o arquivo encontrado dentro de 'dir':
				if (files[i].getName().endsWith(".html")) {
					// System.out.println(files[i].toString());
					enc.addElement(files[i]);
				}
			}
		}
		// Transforma um Vector em um File[]:
		File[] encontrados = new File[enc.size()];
		for (int i = 0; i < enc.size(); i++) {
			encontrados[i] = (File) enc.elementAt(i);
		}
		return encontrados;
	}

}
