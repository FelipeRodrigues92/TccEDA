package br.com.ucb.tcc.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ucb.tcc.dao.LoginDAO;
import br.com.ucb.tcc.modelo.Login;
import br.com.ucb.tcc.modelo.Usuario;
@ManagedBean
@ViewScoped
public class LoginBean {
	Login login = new Login();


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public String efetuaLogin() {
		
		boolean existe = new LoginDAO().existe(this.login);
		if (existe) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.login);
			return "Home?faces-redirect=true";
		}
		return null;
	}
}
