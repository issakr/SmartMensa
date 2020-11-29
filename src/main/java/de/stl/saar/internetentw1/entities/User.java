package de.stl.saar.internetentw1.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	private long userId;
	private String userName;
	private String password;
	private String emailAddress;
	private Role role;
	private boolean passwordResetRequired;
	
	public User() {
		this.userId=0;
	}
	
	public User(long userId, String userName, String password, String emailAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
	}
	
	public User(String userName, String password, String emailAddress) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
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
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Role getRole() {
		return role;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public boolean getPasswordResetRequired() {
		return passwordResetRequired;
	}
	
	public void setPasswordResetRequired(boolean passwordResetRequired) {
		this.passwordResetRequired = passwordResetRequired;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", role=" + role + "]";
	}
	
}
