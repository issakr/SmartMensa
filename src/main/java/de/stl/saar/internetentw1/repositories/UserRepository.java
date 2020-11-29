package de.stl.saar.internetentw1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.stl.saar.internetentw1.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findById(long id);
	List<User> findAll();
	User findByUserName(String userName);
	boolean existsByUserName(String userName);
}
