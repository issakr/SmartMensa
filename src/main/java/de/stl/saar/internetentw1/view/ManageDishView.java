package de.stl.saar.internetentw1.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import de.stl.saar.internetentw1.constants.AppConstants;
import de.stl.saar.internetentw1.entities.Dish;
import de.stl.saar.internetentw1.enums.Category;
import de.stl.saar.internetentw1.services.interfaces.DishService;

/**
 * Controller für ManageDishView.xhtml
 * @author Issam Sakr, David Wagner
 */
@Named
public class ManageDishView implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private DishService dishService;
	private List<Category> categoriesList;
	private Category selectedCategory;
	
	private Dish dishToShow;
	private Dish selectedDish;
	private double minPrice;
	private double maxPrice;

	@PostConstruct
	public void init() {
		categoriesList = new ArrayList<Category>();
		categoriesList.add(Category.getCategoryByName("Suppe"));
		categoriesList.add(Category.getCategoryByName("Nachtisch"));
		categoriesList.add(Category.getCategoryByName("Obst"));
		categoriesList.add(Category.getCategoryByName("Salat"));
		categoriesList.add(Category.getCategoryByName("Hauptgericht"));
	}
	public void preRenderViewInit(ComponentSystemEvent event) {
		selectedCategory=dishToShow.getCategory();
	}
	public void saveNewDish(ActionEvent event) {
		Dish dishToAdd = new Dish();
		dishToAdd = dishToShow;
		dishToAdd.setCategory(Category.getCategoryByName(selectedCategory.toString()));
		dishService.addNewDish(dishToAdd);
	}


	public Dish getSelectedDish() {
		return selectedDish;
	}
	public void setSelectedDish(Dish selectedDish) {
		this.selectedDish = selectedDish;
	}
	public Dish getDishToShow() {
		return dishToShow;
	}
	public void setDishToShow(Dish dishToShow) {
		this.dishToShow = dishToShow;
	}
	
	public List<Category> getCategoriesList() {
		return categoriesList;
	}
	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}
	public Category getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	public double getMinPrice() {
		return AppConstants.MIN_PRICE;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return AppConstants.MAX_PRICE;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
