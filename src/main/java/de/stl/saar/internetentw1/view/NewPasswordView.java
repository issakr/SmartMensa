package de.stl.saar.internetentw1.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import de.stl.saar.internetentw1.entities.User;
import de.stl.saar.internetentw1.services.interfaces.UserService;
import de.stl.saar.internetentw1.utils.RandomUtils;

@Named

public class NewPasswordView implements Serializable{

	@Inject
	private UserService userService;
	private static final long serialVersionUID = 1L;
	private String password;
	private String confirm_password;
	private User userToModify;
	private String userNameToModify;
	private String newPassword;
	
	
	@PostConstruct
	public void init() {
	}
	public void initialize(ComponentSystemEvent event) {
		setUserToModify(userService.getUserByUserName(userNameToModify));
		password=newPassword;
		confirm_password=newPassword;		
	}

	/**
	 * prüft ob Passwort zweimal gleich eingegeben wurde
	 * wenn nicht Fehlermeldung
	 * setzt Passorterneuerung auf nicht benötigt
	 * @return bei Erfolg Startseite
	 */
	public String saveNewPassword() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Fehler Passwortänderung fehlgeschlagen!","changePasswordFehler");
		
		if(getPassword().equals(getConfirm_password())) {
			getUserToModify().setPassword(password);
			getUserToModify().setPasswordResetRequired(false);
			userService.saveUser(getUserToModify());
			return "startseite";
		}
		context.addMessage(null, message);
		return null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public User getUserToModify() {
		return userToModify;
	}

	public void setUserToModify(User userToModify) {
		this.userToModify = userToModify;
	}
	public String getUserNameToModify() {
		return userNameToModify;
	}
	public void setUserNameToModify(String userNameToModify) {
		this.userNameToModify = userNameToModify;
	}
	public String getNewPassword(){
		return newPassword;
	}

	public void setNewPassword(String newPassword){
		this.newPassword = newPassword;
	}
	
}
