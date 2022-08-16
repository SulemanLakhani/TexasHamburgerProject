package com.hamburger.texashamburgercompany.service;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantLocationService {

    List<RestaurantLocations> getAllLocations();

    RestaurantLocations getRestaurantById(Long id);

    RestaurantLocations addOrUpdateLocation(RestaurantLocations restaurantLocation);

    RestaurantLocations deleteLocation(Long id) throws Exception;

    List<RestaurantLocations> getRestaurantsWithSorting(String field);

    Page<RestaurantLocations> getRestaurantsWithPagination(int offset, int pageSize);
}
