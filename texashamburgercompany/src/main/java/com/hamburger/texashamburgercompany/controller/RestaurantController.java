package com.hamburger.texashamburgercompany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import com.hamburger.texashamburgercompany.repository.RestaurantLocationsRepository;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantLocationsRepository repository;

	@GetMapping("/restaurants")
	public List<RestaurantLocations> getAllRestaurantLocations() {
		return repository.findAll();
	}

	@PostMapping("/addRestaurant")
	public RestaurantLocations addRestaurant(@RequestBody RestaurantLocations restaurantLocation) {
		return repository.save(restaurantLocation);
	}

	@GetMapping("/restaurants/{id}")
	public RestaurantLocations getRestaurantLocationsById(@PathVariable("id") Long id) {
		Optional<RestaurantLocations> opt = repository.findById(id);

		if (opt.isEmpty()) {
			throw new RuntimeException("Id is not Valid");
		}
		RestaurantLocations restaurantLocation = opt.get();

		return restaurantLocation;
	}

	@DeleteMapping("deleteRestaurant/{id}")
	public Long deleteRestaurantById(@PathVariable("id") Long id) {

		Optional<RestaurantLocations> opt = repository.findById(id);

		if (opt.isEmpty()) {
			throw new RuntimeException("Id is not Valid");
		}
		RestaurantLocations restaurantLocation = opt.get();
		repository.delete(restaurantLocation);
		
		return id;
	}

}
