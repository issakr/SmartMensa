package de.stl.saar.internetentw1.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.stl.saar.internetentw1.entities.Dish;
import de.stl.saar.internetentw1.services.interfaces.DishService;


@Named
public class DishesManagementView {
	@Inject
	private DishService dishService;
	private DataModel<Dish> myDishes;
	private Dish selectedDish;
	private Dish newDish;

	
	@PostConstruct
	public void initialize() {
		newDish = new Dish();
		List<Dish> dishesList = new ArrayList<Dish>();
		dishesList.addAll(dishService.getAllDishes());
		myDishes = new ListDataModel<Dish>();
		myDishes.setWrappedData(dishesList);
	}


	public Dish getNewDish() {
		return newDish;
	}


	public void setNewDish(Dish newDish) {
		this.newDish = newDish;
	}


	public void removeDish() {
		dishService.deleteDishById(selectedDish.getDishId());
	}
	

	public String toManageDish() {
		return "manageDish";
	}
	
	
	public Dish getSelectedDish() {
		return selectedDish;
	}


	public void setSelectedDish(Dish selectedDish) {
		this.selectedDish = selectedDish;
	}


	public DataModel<Dish> getMyDishes() {
		return myDishes;
	}

	public void setMyDishes(DataModel<Dish> myDishes) {
		this.myDishes = myDishes;
	}
	
}
