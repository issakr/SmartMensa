package de.stl.saar.internetentw1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.stl.saar.internetentw1.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findById(long roleId);
	Role findByRoleName(String roleName);
	List<Role> findAll();
}
