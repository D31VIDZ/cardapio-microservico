package com.example.menuservice.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.menuservice.dots.DishDTO;
import com.example.menuservice.entities.Dish;
import com.example.menuservice.services.DishService;

@RestController
@RequestMapping("/menu")
public class DishController {

	@Autowired
	DishService service;
	
	@GetMapping
	public List<Dish> getAll(){
		List<Dish> dishes = service.getAll();
		return dishes;
	}
		
	@GetMapping("/{dishId}")
	public ResponseEntity<Dish> getDishById(@PathVariable Long dishId) throws Exception{
		
		Optional<Dish> dishOp = service.getDishById(dishId);
		
		if(dishOp.isPresent()) {
			Dish dish = dishOp.get();
			return ResponseEntity.ok(dish);
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public void SetDish(@Valid DishDTO dish) {
		service.createDish(dish);
	}
}
