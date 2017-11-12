package br.com.ucb.tcc.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

public class EmailJava {
	
	Email email;
	
	public EmailJava() {
		email = new SimpleEmail();
		configure();
	}
	public void configure() {
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setDebug(true);
		email.setAuthenticator(new DefaultAuthenticator("tccgestorconteudista@gmail.com", "tcc123123"));
		email.setSSLOnConnect(true);
	}
	public void enviarEmail(String emissor, String assunto, String mensagem, String destinatario){
		try {
			
			email.setFrom(emissor);
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(destinatario);
			email.send();
		} catch (EmailException ex) {
			// TODO: handle exception
			//Logger.getLogger(EmailJava.class.getName()).log(Level , null , ex);
		}
	}
}
