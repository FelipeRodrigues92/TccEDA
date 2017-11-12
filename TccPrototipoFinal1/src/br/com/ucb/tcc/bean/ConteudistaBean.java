package br.com.ucb.tcc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.ConteudistaDAO;
import br.com.ucb.tcc.dao.DAO;
import br.com.ucb.tcc.modelo.Conteudista;
import br.com.ucb.tcc.modelo.Curriculo;
import br.com.ucb.tcc.modelo.Endereco;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.modelo.UnidadeFederacao;
import br.com.ucb.tcc.modelo.Usuario;
import br.com.ucb.tcc.util.GerenciadorEmail;

@ManagedBean
@SessionScoped
public class ConteudistaBean {

	private Endereco endereco = new Endereco();

	private Curriculo curriculo = new Curriculo();

	private Conteudista conteudista = new Conteudista();

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setConteudista(Conteudista conteudista) {
		this.conteudista = conteudista;
	}

	public Conteudista getConteudista() {
		return conteudista;
	}

	public String formCurso() {
		System.out.println("Chamando  o formulário do curso");
		return "CadastroCurso?faces-redirect=true";
	}

	public List<Conteudista> getPerfil() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		Conteudista conteudista = new DAO<Conteudista>(Conteudista.class).buscaPorId(usuarioId);
		List<Conteudista> lista = new ArrayList<Conteudista>();
		lista.add(conteudista);
		this.conteudista = lista.get(0);
		return lista;
	}

	public String cadastroSimples() {
		//this.conteudista.setEndereco(this.endereco);
		//this.curriculo.setConteudista(this.conteudista);
		Conteudista newConteudista = new Conteudista();
		newConteudista.setNome(this.conteudista.getNome());
		newConteudista.setEmail(this.conteudista.getEmail());
		newConteudista.setSenha(this.conteudista.getSenha());
		Login login = new Login();
		login.setEmail(conteudista.getEmail());
		login.setSenha(conteudista.getSenha());
		new DAO<Login>(Login.class).adiciona(login);
		new DAO<Conteudista>(Conteudista.class).adiciona(newConteudista);
		//new ConteudistaDAO().gravar(this.conteudista, this.endereco, this.curriculo);
		GerenciadorEmail.enviarEmailConfirmacaoCadastro(conteudista.getEmail(), conteudista.getSenha());
		return RotasBean.goLogin();

	}

	public String gravar() {

		
		this.conteudista.setEndereco(this.endereco);
		this.curriculo.setConteudista(this.conteudista);
		Login login = new Login();
		login.setEmail(conteudista.getEmail());
		login.setSenha(conteudista.getSenha());
		new DAO<Login>(Login.class).adiciona(login);
		new ConteudistaDAO().gravar(this.conteudista, this.endereco, this.curriculo);
		GerenciadorEmail.enviarEmailConfirmacaoCadastro(conteudista.getEmail(), conteudista.getSenha());
		return RotasBean.goLogin();
	}

	public String alterar() {
		System.out.println("Alterando conteudista" + this.conteudista.getNome());
		System.out.println("endereco" + this.endereco.getId());
		System.out.println("conteudista " + this.conteudista.getId());

		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		this.endereco.setId(conteudista.getEndereco().getId());
		this.conteudista.setId(usuarioId);
		new ConteudistaDAO().atualiza(this.getConteudista(), this.getEndereco());
		return "Home?faces-redirect=true";
	}

	public Boolean isADM() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if (usuarioId == 1) {
			return true;
		}
		return false;
	}

	public Boolean isSubADM() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if (usuarioId == 2) {
			return true;
		}
		return false;
	}

	public Boolean isSubADMOrADM() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
		if (usuarioId == 2 || usuarioId == 2) {
			return true;
		}
		return false;
	}

	public void carregarConteudista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");

		if ((usuarioId != null) && (usuarioId > 2)) {
			this.conteudista = new DAO<Conteudista>(Conteudista.class).buscaPorId(usuarioId);
			this.endereco = new DAO<Endereco>(Endereco.class).buscaPorId(conteudista.getEndereco().getId());
			System.out.println("endereco" + endereco.getId());
			System.out.println("conteudista " + conteudista.getId());
			this.setConteudista(new DAO<Conteudista>(Conteudista.class).buscaPorId(usuarioId));
			this.setEndereco(new DAO<Endereco>(Endereco.class).buscaPorId(conteudista.getEndereco().getId()));
		}
	}
}
