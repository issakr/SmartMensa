package de.stl.saar.internetentw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SmartMensaApplication {
	/**
	 * Startklasse des Projekts
	 * localhost:8080/index.html zum starten
	 * @author Issam Sakr
	 */
	public static void main(String[] args) {
		SpringApplication.run(SmartMensaApplication.class, args);
		System.out.println("Ready");
	}
	
}
