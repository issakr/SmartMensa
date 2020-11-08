package de.stl.saar.internetentw1.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.stl.saar.internetentw1.entities.Dish;
import de.stl.saar.internetentw1.services.interfaces.DishService;
/**
 * Controller für menu.xhtml
 * @author Issam Sakr, David Wagner
 */

@Named
@ViewScoped
public class MenuView {
	@Inject
	private DishService dishService;
	private DataModel<Dish> myDishes;	
	private DataModel<Dish> myOrders;
	private List<Dish> dishesList;
	private List<Dish> orderedDishesList;
	
	private double totalPrice;
	private Dish orderedDish;
	private Dish selectedDish;
	private boolean orderReady;
	@PostConstruct
	public void initializeBean() {
		dishesList= new ArrayList<Dish>();
		orderedDishesList=new ArrayList<Dish>();
		myDishes = new ListDataModel<Dish>();
		myDishes.setWrappedData(dishesList);
		myOrders = new ListDataModel<Dish>();
		myOrders.setWrappedData(orderedDishesList);
		
		
	}
	public void initialize(ComponentSystemEvent event) {
		dishesList.clear();
		dishesList.addAll(dishService.getAllDishes());
	}
	public void removeFromOrderedDish() {
		orderedDishesList.remove(orderedDish);
		totalPrice-=orderedDish.getPrice();
		if(orderedDishesList.isEmpty())
			orderReady=false;
	}
	public String getImages(Dish dish) {
		return "/images/"+dish.getImageName()+".jpg";
	}
	public void addToCart() {
		orderedDishesList.add(selectedDish);
		totalPrice+=selectedDish.getPrice();
		setOrderReady(true);
	}

	public String bestellen() {
		if(orderedDishesList.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Warenkorb ist leer!","CartFehler"));
		}
		return "toOrder";
	}
	
	public boolean isOrderReady() {
		return orderReady;
	}
	public void setOrderReady(boolean orderReady) {
		this.orderReady = orderReady;
	}
	public Dish getOrderedDish() {
		return orderedDish;
	}

	public void setOrderedDish(Dish orderedDish) {
		this.orderedDish = orderedDish;
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

	public DataModel<Dish> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(DataModel<Dish> myOrders) {
		this.myOrders = myOrders;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
