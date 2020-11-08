package de.stl.saar.internetentw1.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import de.stl.saar.internetentw1.model.Room;
@Named
public class RoomConverter implements Converter<Room>{

	@Override
	public Room getAsObject(FacesContext context,
							UIComponent component,
							String value) {
		
		if(value.length() != 4) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"RoomConverter fehlgeschlagen!","RoomConverterFehler");
            throw new ConverterException(message);
		}
		int building =Integer.parseInt(value.substring(0, 1));
		int floor= Integer.parseInt(value.substring(1, 2));
		int roomNr=Integer.parseInt(value.substring(2, 4));
		if(roomNr<10) {
			roomNr=Integer.parseInt(value.substring(3, 4));
		}
		return new Room(building, floor, roomNr);
		
	}

	@Override
	public String getAsString(FacesContext context,
							  UIComponent component,
							  Room value) {
		StringBuilder room = new StringBuilder(); 
		room.append(Integer.toString(value.getBuilding()));
		room.append(Integer.toString(value.getFloor()));
		if(value.getRoom()<10) {
			room.append("0");
		}
		room.append(Integer.toString(value.getRoom()));
		System.out.println(room.toString());
		return room.toString();
	}

}
