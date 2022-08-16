package com.hamburger.texashamburgercompany.controller;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import com.hamburger.texashamburgercompany.service.RestaurantLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantLocationService restService;

	Logger logger = LoggerFactory.getLogger(RestaurantController.class);

	@GetMapping("/restaurants")
	public List<RestaurantLocations> getAllRestaurantLocations() {

		List<RestaurantLocations> restaurantLocations = null;
			try{
				restaurantLocations = restService.getAllLocations();
			} catch(Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		logger.error("API called with response: " + restaurantLocations);

		return restaurantLocations;
	}

	@PostMapping("/addRestaurant")
	public RestaurantLocations addRestaurant(@RequestBody RestaurantLocations restaurantLocation) {
		RestaurantLocations restaurantLocations = null;
		try {
			restaurantLocations = restService.addOrUpdateLocation(restaurantLocation);
		} catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}

		logger.error("Restaurant Added: " + restaurantLocations);
		return restaurantLocations;
	}

	@GetMapping("/restaurants/{id}")
	public RestaurantLocations getRestaurantLocationsById(@PathVariable("id") Long id) {
		RestaurantLocations restaurantLocations = null;
		try {
			restaurantLocations = restService.getRestaurantById(id);
		} catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}

		logger.error("Restaurant Location By Id: " + restaurantLocations);
		return restaurantLocations;
	}

	@DeleteMapping("deleteRestaurant/{id}")
	public RestaurantLocations deleteRestaurantById(@PathVariable("id") Long id) {

		RestaurantLocations restaurantLocations = null;
		try {
			restaurantLocations = restService.deleteLocation(id);
		} catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}

		logger.error("Restaurant deleted: " + restaurantLocations);
		return restaurantLocations;
	}

	@GetMapping("/restaurantsWithSorting/{field}")
	public List<RestaurantLocations> getRestaurantsWithSorting(@PathVariable("field") String field){
		List<RestaurantLocations> restaurantLocations = null;
		try{
			restaurantLocations = restService.getRestaurantsWithSorting(field);
		} catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.error("API called with response: " + restaurantLocations);

		return restaurantLocations;
	}

	@GetMapping("restaurantsWithPagination/{offset}/{pageSize}")
	public Page<RestaurantLocations> restaurantsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
		Page<RestaurantLocations> restaurantLocationsWithPagination = restService.getRestaurantsWithPagination(offset,pageSize);
		return restaurantLocationsWithPagination;
	}
}