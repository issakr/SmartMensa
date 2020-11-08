package de.stl.saar.internetentw1.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.stl.saar.internetentw1.entities.User;
import de.stl.saar.internetentw1.services.interfaces.UserService;



@Named
public class UsersManagementView {
	@Inject
	private UserService userService;
	private DataModel<User> myUsers;
	private long userIdToRemove=0;	
	private User actuelUser;
	private User selectedUser;
	private User newUser;
	@PostConstruct
	public void initialize() {
		List<User> userList= new ArrayList<User>();
		userList.addAll(userService.getAllUsers());
		myUsers = new ListDataModel<User>();
		myUsers.setWrappedData(userList);
		setNewUser(new User());
	}
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public void removeUser() {
		userService.deleteUserById(selectedUser.getUserId());
	}
	
	public String toManageUser() {
		return "manageUser";
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public long getUserIdToRemove() {
		return userIdToRemove;
	}
	public void setUserIdToRemove(long userIdToRemove) {
		this.userIdToRemove = userIdToRemove;
	}
	public DataModel<User> getMyUsers() {
		return myUsers;
	}
	

	public User getActuelUser() {
		return actuelUser;
	}

	public void setActuelUser(User actuelUser) {
		this.actuelUser = actuelUser;
	}

	public void setMyUsers(DataModel<User> myUsers) {
		this.myUsers = myUsers;
	}
	
}
