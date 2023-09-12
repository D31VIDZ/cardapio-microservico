package com.example.menuservice.entities;


import javax.validation.constraints.NotBlank;

import com.example.menuservice.dots.DishDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Dishes")
@Table(name = "Dishes")
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "nome invalido")
	private String name;
	
	private String description;
	
	@NotBlank(message = "preço invalido")
	private Double price;
	
	public Dish() {
	}
	
	public Dish(DishDTO dish) {
		this.name = dish.name();
		this.description = dish.description();
		this.price = dish.price();
	}

	public Dish(String name, String description, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
