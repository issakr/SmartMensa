package de.stl.saar.internetentw1.services.interfaces;

import java.util.List;

import de.stl.saar.internetentw1.entities.Dish;

public interface DishService {

	List<Dish> getAllDishes();

	boolean deleteDishById(long dishId);

	boolean addNewDish(Dish dish);

	Dish getDishById(long id);

}
