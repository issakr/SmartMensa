package de.stl.saar.internetentw1.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import de.stl.saar.internetentw1.model.Room;

/**
 * Selbstdefinierter Velidierer um einen Raum Laut HTW-regeln zu validieren.
 * @author Issam Sakr
 */

@FacesValidator("roomValidator")
public class RoomValidator implements Validator<Room>{

	/**
	 * Methode, die die Korrektheit der Raumnummer nach den enstrechenden Bedingungen valdiert
	 * Fehlerausgabe im Fehlerfall
	 * @param Room value : Der zu validierende Raum
	 */
	@Override
	public void validate(FacesContext context,
						 UIComponent component,
						 Room value)
						throws ValidatorException {
		if(value.getBuilding()<= 0 || value.getBuilding()>8) {
			FacesMessage message = new FacesMessage("Gebaeudenummer muss zwischen 1 und 8 liegen");
			throw new ValidatorException(message);
		}
		if(value.getFloor() <= 0 || value.getFloor()>2) {
			FacesMessage message = new FacesMessage("Etagenummer muss zwischen 1 und 2 liegen");
			throw new ValidatorException(message);
		}
		if(value.getRoom() <= 0 || value.getRoom() > 20){
			FacesMessage message = new FacesMessage("Raumnummer muss zwischen 1 und 20 liegen");
			throw new ValidatorException(message);
		}
	}

}
