package com.example.menuservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.menuservice.entities.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{

}