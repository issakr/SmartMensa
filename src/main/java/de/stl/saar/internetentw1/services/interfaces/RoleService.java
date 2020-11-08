package de.stl.saar.internetentw1.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import de.stl.saar.internetentw1.entities.Role;

/**
 *RoleServices Interface
 * @author Issam Sakr, David Wagner
 */

@Service
public interface RoleService {
	List<Role> getAllRolen();

	Role getRoleByRoleName(String roleName);

	Role getRoleById(long id);

	Role getRole(String roleName);
}
