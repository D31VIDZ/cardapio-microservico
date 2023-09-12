package com.example.menuservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuservice.dots.DishDTO;
import com.example.menuservice.entities.Dish;
import com.example.menuservice.repositories.DishRepository;

@Service
public class DishService {

	@Autowired
	DishRepository repository;
	
	public List<Dish> getAll(){
		return repository.findAll();
	}
	
	public Optional<Dish> getDishById(Long dishId) throws Exception {
		Optional<Dish> dish = repository.findById(dishId);
		if(dish == null) {
			throw new Exception("prato não encontrado!");
		}else {
		return dish;
		}
	}
	
	public void createDish(DishDTO dish) {
		Dish dis = new Dish(dish);
		this.addDish(dis);
	}
	
	public void addDish(Dish di) {
		repository.save(di);
	}
}