package de.stl.saar.internetentw1.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.stl.saar.internetentw1.entities.*;
import de.stl.saar.internetentw1.services.interfaces.*;
import de.stl.saar.internetentw1.utils.RandomUtils;

/**
 * 
 * Controller für ManageUser.xhtml
 * @author Issam Sakr, David Wagner
 */

@Named
public class ManageUserView implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private UserService userService;
	@Inject
	private RoleService roleService;
	private long id;
	private User userToShow;
	private boolean itemToShow;
	private List<Role> rolenList;
	private Role selectedRole;
	@PostConstruct
	public void init() {
		rolenList = new ArrayList<Role>();
		selectedRole = new Role();
	}
	
	public void preRenderViewInit(ComponentSystemEvent event) {
		if(id == 0) {
			setUserToShow(new User());
		}else {
			setUserToShow(userService.getUserById(id));
		}
		selectedRole=userToShow.getRole();
		rolenList.clear();
		rolenList.addAll(roleService.getAllRolen());
	}
	public void saveUser() {
		userToShow.setRole(selectedRole);
		userService.saveUser(userToShow);
	}
	public String createRandomPassword(){
		userToShow.setPasswordResetRequired(true);
		userService.saveUser(userToShow);
		return RandomUtils.createStringWithRandomChars(8);

	}
	public String toNewPassword(){
		return "NewPass";
	}
	public void showItems() {
		setItemToShow(true);
	}
	public void hideItems() {
		setItemToShow(false);
	}

	public User getUserToShow() {
		return userToShow;
	}


	public void setUserToShow(User userToShow) {
		this.userToShow = userToShow;
	}

	public List<Role> getRolenList() {
		return rolenList;
	}

	public void setRolenList(List<Role> rolenList) {
		this.rolenList = rolenList;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}


	public boolean getItemToShow() {
		return itemToShow;
	}

	public void setItemToShow(boolean itemToShow) {
		this.itemToShow = itemToShow;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}