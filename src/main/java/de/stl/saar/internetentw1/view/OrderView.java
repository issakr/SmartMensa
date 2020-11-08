package de.stl.saar.internetentw1.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import de.stl.saar.internetentw1.constants.AppConstants;
import de.stl.saar.internetentw1.model.Room;


@Named
@ViewScoped
public class OrderView implements Serializable{

	private static final long serialVersionUID = 1L;
	private Room room;
	private String ownName;
	private boolean alreadyOrdered;
	
	@PostConstruct
	public void initialize() {
		ownName="";
	}

	public void makeOrder(ActionEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null,
				new FacesMessage("Successful."," Ihre Bestellung ist auf dem Weg zu Raum: "+customizeRoom(room)) );
		setAlreadyOrdered(true);
	}
	
	/**
	 * bildet Raumnummer als String
	 * @param value Der Raum
	 * @return	Raum als String
	 */
	private String customizeRoom(Room value) {
		StringBuilder room = new StringBuilder(); 
		room.append(Integer.toString(value.getBuilding()));
		room.append(Integer.toString(value.getFloor()));
		if(value.getRoom()<10) {
			room.append("0");
		}
		room.append(Integer.toString(value.getRoom()));
		return room.toString();
	}
	

	public int getMinNameLenght() {
		return AppConstants.NAME_MIN;
	}

	public boolean isAlreadyOrdered() {
		return alreadyOrdered;
	}

	public void setAlreadyOrdered(boolean alreadyOrdered) {
		this.alreadyOrdered = alreadyOrdered;
	}

	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getOwnName() {
		return ownName;
	}
	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}
	
}
