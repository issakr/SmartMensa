package de.stl.saar.internetentw1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.stl.saar.internetentw1.enums.Category;

@Entity
public class Dish {
	private long dishId;
	private String dishName;
	private double price;
	private String imageName;
	private Category category;
	
	public Dish() {
		super();
	}

	public Dish(long dishId, String dishName, double price, Category category, String imageName) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.imageName = imageName;
		this.category = category;
	}
	
	public Dish(String dishName, double price, Category category, String imageName) {
		super();
		this.dishName = dishName;
		this.price = price;
		this.imageName = imageName;
		this.category = category;
	}
	
	public String getDishName() {
		return dishName;
	}
	
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getDishId() {
		return dishId;
	}
	
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DishEntity [dishId=" + dishId + ", dishName=" + dishName + ", price=" + price + ", imageName="
				+ imageName + ", category=" + category.toString() + "]";
	}
	
}
