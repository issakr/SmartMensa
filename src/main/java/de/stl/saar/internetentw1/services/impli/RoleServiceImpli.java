package de.stl.saar.internetentw1.services.impli;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.stl.saar.internetentw1.entities.Role;
import de.stl.saar.internetentw1.repositories.RoleRepository;
import de.stl.saar.internetentw1.services.interfaces.RoleService;
import de.stl.saar.internetentw1.utils.StringUtils;

/**
 * Implementierung des RoleServices
 * @author Issam Sakr, David Wagner
 */
@Named
public class RoleServiceImpli implements RoleService{
	@Autowired
	private RoleRepository roleRepo;
	
	private List<Role> rolenList;
	
	public RoleServiceImpli() {
	}
	@Override
	public List<Role> getAllRolen(){
		rolenList = new ArrayList<Role>();
		roleRepo.findAll().forEach(role ->
			rolenList.add(role));
		return rolenList;
	}
	
	@Override
	public Role getRoleByRoleName(final String roleName) {
		return roleRepo.findByRoleName(roleName);
	}
	@Override
	public Role getRoleById(long id) {
		return roleRepo.findById(id);
	}
	@Override
	public Role getRole(String roleName) {
		System.out.println("roleName in Server: "+roleName+"=");
		if(StringUtils.areStringsEqual(roleName, "administrator"))
			return roleRepo.findById(1);
		else if(StringUtils.areStringsEqual(roleName, "user"))
			return roleRepo.findById(2);
		else
			return null;
	}
}
