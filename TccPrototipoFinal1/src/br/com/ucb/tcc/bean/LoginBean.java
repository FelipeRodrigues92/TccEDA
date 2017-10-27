package br.com.ucb.tcc.bean;

import javax.faces.application.FacesMessage;
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
		FacesContext context = FacesContext.getCurrentInstance();
		if (existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.login);
			Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().get("usuarioId");
			if(usuarioId == 1) {
				return "HomeAdm?faces-redirect=true";
			}else if(usuarioId == 2){
				return "HomeSubAdm?faces-redirect=true";
			}else {
				return "Home?faces-redirect=true";
			}
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario não encontrado"));
		return "Login?faces-redirect=true";
	}
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado", this.login);
		Integer usuarioId = (Integer) context.getExternalContext().getSessionMap().remove("usuarioId");
		return "Login?faces-redirect=true";
	}
}
