package de.stl.saar.internetentw1.services.impli;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.stl.saar.internetentw1.entities.User;
import de.stl.saar.internetentw1.repositories.UserRepository;
import de.stl.saar.internetentw1.services.interfaces.UserService;


@Named
public class UserServiceImpli implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	
	public UserServiceImpli() {
		
	}


	@Override
	public User getUserById(long id) {
		return userRepo.findById(id);
	}


	@Override
	public User getUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public boolean saveUser(User user) {
		userRepo.save(user);
		if(userRepo.existsById(user.getUserId())) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean editUser(long oldUserId, User newUser) {
			newUser.setUserId(oldUserId);
			deleteUser(userRepo.findById(oldUserId));
			saveUser(newUser);
			return true;
	}
	@Override
	public boolean deleteUser(User user) {
		if(userRepo.existsById(user.getUserId())) {
			userRepo.delete(user);
			return true;
		}else {
			System.out.println("user existiert nicht!!");
			return false;
		}
	}


	@Override
	public boolean deleteUserById(long userId) {
		if(userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			return true;
		}else {
			System.out.println(userId+" existiert nicht!!");
			return false;
		}
	}

}
