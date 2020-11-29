package de.stl.saar.internetentw1.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.stl.saar.internetentw1.entities.Dish;
import de.stl.saar.internetentw1.entities.Role;
import de.stl.saar.internetentw1.entities.User;
import de.stl.saar.internetentw1.enums.Category;
import de.stl.saar.internetentw1.repositories.DishRepository;
import de.stl.saar.internetentw1.repositories.RoleRepository;
import de.stl.saar.internetentw1.repositories.UserRepository;
/**
 * Initialisiert Datenbank mit Testdatensätzen
 * 
 */
@Component
public class DatabaseUtil {
	@Autowired
	private DishRepository dishRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	private static final String ROLE_NAME_ADMINISTATOR = "administrator";
	private static final String ROLE_NAME_USER = "user";
	
	/**
	 * Initialisiert alle Tabellen durch Aufruf der einzelnen Initailisierungen
	*/
	@PostConstruct
	public void initializeDatabase() {
		initializeDishTable();
		initializeRoleTable();
		initializeUserTable();

	}
	
	/**
	 * Initialisiert Gerichte Tabelle
	 */
	private void initializeDishTable() {
		dishRepository.save(new Dish("Quetschekouchen", 2.0, Category.DESSERT, "Quetschekouchen"));
		dishRepository.save(new Dish("Creme Brulee", 2.5, Category.DESSERT, "cremeBrulee"));
		dishRepository.save(new Dish("Schwenkbraten", 7.5, Category.MAIN_DISH, "Schwenkbraten"));
		dishRepository.save(new Dish("Grießnockerl-Suppe", 4, Category.SOUP, "griessnockerlsuppe"));
		dishRepository.save(new Dish("Griessknepp", 2, Category.DESSERT, "Grießknepp"));
		dishRepository.save(new Dish("Merziger Viezsüppchen", 3.5, Category.SOUP, "Merziger_Viezsüppchen"));
		dishRepository.save(new Dish("Schnittlauch Eier Salat", 3.5, Category.SALAD, "Schnittlauch-Eier-Salat"));
		dishRepository.save(new Dish("Plattgeschmelzde", 3.5, Category.MAIN_DISH, "plattgeschmelzde"));
		dishRepository.save(new Dish("Lyonerpfanne", 7.0, Category.MAIN_DISH, "lyoner-Pfanne"));
		dishRepository.save(new Dish("Verheirade mit Saiblingsfilet", 4.0, Category.SALAD, "Verheirade-mit-Saiblingsfilet"));
	}
	
	/**
	 * Initalisiert Rollentabelle
	 */

	private void initializeRoleTable() {
		roleRepository.save(new Role(ROLE_NAME_ADMINISTATOR));
		roleRepository.save(new Role(ROLE_NAME_USER));
	}
	
	public static String getRoleNameAdministator() {
		return ROLE_NAME_ADMINISTATOR;
	}
	/**
	 * initialisiert Benutzertabelle
	 */
	private void initializeUserTable() {
		final Role administratorRole = roleRepository.findByRoleName(ROLE_NAME_ADMINISTATOR);
		final Role userRole =  roleRepository.findByRoleName(ROLE_NAME_USER);
		final User colbertz = new User("colbertz", "1234", "colbertz@htwsaar.de");
		final User api = new User("api", "5678", "api@htwsaar.de");
		final User wpy = new User("wpy", "qwertz", "wpy@htwsaar.de");
		colbertz.setRole(administratorRole);
		api.setRole(userRole);
		wpy.setRole(userRole);
		userRepository.save(colbertz);
		userRepository.save(wpy);
		userRepository.save(api);
	}
}
