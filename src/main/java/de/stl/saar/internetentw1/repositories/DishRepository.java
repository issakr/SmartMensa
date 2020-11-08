package de.stl.saar.internetentw1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.stl.saar.internetentw1.entities.Dish;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long>{
	Dish findById(long dishId);
	List<Dish> findAll();
}
