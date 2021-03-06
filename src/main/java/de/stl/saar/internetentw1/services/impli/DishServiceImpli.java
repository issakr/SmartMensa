package de.stl.saar.internetentw1.services.impli;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import de.stl.saar.internetentw1.entities.Dish;
import de.stl.saar.internetentw1.repositories.DishRepository;
import de.stl.saar.internetentw1.services.interfaces.DishService;

@Named
public class DishServiceImpli implements DishService{
	@Autowired
	private DishRepository dishRepo;
	
	public DishServiceImpli() {
	}
	@Override
	public List<Dish> getAllDishes() {
		return dishRepo.findAll();
	}
	@Override
	public boolean deleteDishById(long dishId) {
		if(dishRepo.existsById(dishId)) {
			dishRepo.deleteById(dishId);
			return true;
		}else {
			System.out.println(dishId+" existiert nicht");
			return false;
		}
		
	}
	@Override
	public boolean addNewDish(Dish dish) {
		dishRepo.save(dish);
		if(dishRepo.existsById(dish.getDishId())) {
			System.out.println("Dish saved");
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Dish getDishById(long id) {
		
		return dishRepo.findById(id);
	}
}
