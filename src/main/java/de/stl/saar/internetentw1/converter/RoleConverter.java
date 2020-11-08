package de.stl.saar.internetentw1.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import de.stl.saar.internetentw1.entities.Role;
import de.stl.saar.internetentw1.services.interfaces.RoleService;
@FacesConverter(forClass=Role.class)
@Service
public class RoleConverter implements Converter<Role>{
	@Inject
	private RoleService roleService;

	private Role role;
	@Override
	public Role getAsObject(FacesContext context,
							UIComponent component,
							String value) {
		role =roleService.getRoleByRoleName(value);
		return role;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Role value) {
		return value.toString();
	}


	
	

}
