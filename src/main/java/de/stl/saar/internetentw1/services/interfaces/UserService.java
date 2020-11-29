package de.stl.saar.internetentw1.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import de.stl.saar.internetentw1.entities.User;


@Service
public interface UserService {
	boolean saveUser(User user);
	boolean deleteUser(User user);
	boolean deleteUserById(long userId);
	boolean editUser(long id, User newUser);
	
	List<User> getAllUsers();
	
	User getUserByUserName(String userName);
	User getUserById(long id);
	
}
