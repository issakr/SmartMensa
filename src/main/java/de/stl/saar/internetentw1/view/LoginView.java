package de.stl.saar.internetentw1.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import de.stl.saar.internetentw1.entities.User;
import de.stl.saar.internetentw1.services.interfaces.UserService;
import de.stl.saar.internetentw1.utils.DatabaseUtil;

/**
 * Diese Bean managed Login Fenster, es prüft die eingabe und erstellt einen globalen User.
 * @author Lucky Ace
 *
 */
@Named
@SessionScoped
public class LoginView implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private UserService userService;
	private List<User> userList;
	private User actuelUser;
	private String userName;
	private String password;
	private boolean isConnected;
	@PostConstruct
	public void initializeBean() {
		userList = new ArrayList<User>();
		
	}
	public void initialize(ComponentSystemEvent event) {
		userName = "";
		password = "";
		userList.clear();
		userList.addAll(userService.getAllUsers());
	}

	/**
	 * sucht User anhand Usernamen, prüft passwort wenn gefunden.
	 * Ansonsten Fehlerausgabe
	 * Prüft bei Erfolg ob Passworterneuerung erforderlicht ist
	 * @return die entsprechende Seite, je nach Erfolg oder erforderlicher Passworterneuerung
	 */

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Fehler Authentifizierung fehlgeschlagen!","loginFehler");
		
		for(User user :userList) {
			if(user.getUserName().equals(userName)) {
				if(user.getPassword().equals(password)) {
					setActuelUser(user);
					
					if(actuelUser.getPasswordResetRequired()) {
						System.out.println("actuelUser: "+getActuelUser().toString());
						return "NewPass";
					}else {
						setConnected(true);
						return "startseite";
					}
				}
			}
		}
		context.addMessage(null, message);
		return null;
	}
	/**
	 * loggt den Benutzer uas
	 */
	public void logout(ActionEvent event) {
		System.out.println("logged out");
		setConnected(false);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		        
	}

	/**
	 * prüft ob der Benutzer Adminrechte hat
	 * @return boolean true : Benutzer ist Admin, false: Benutzer ist kein Admin
	 */
	public boolean istAdmin() {
		if(getActuelUser().getRole().getRoleName()==DatabaseUtil.getRoleNameAdministator()) {
			return true;
		}
		return false;
	}
	
	
	public boolean isConnected() {
		return isConnected;
	}
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getActuelUser() {
		return actuelUser;
	}

	public void setActuelUser(User actuelUser) {
		this.actuelUser = actuelUser;
	}


	


}
