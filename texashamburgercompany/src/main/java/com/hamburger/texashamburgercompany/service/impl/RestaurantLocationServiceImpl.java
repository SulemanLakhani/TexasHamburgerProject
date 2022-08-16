package com.hamburger.texashamburgercompany.service.impl;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import com.hamburger.texashamburgercompany.repository.RestaurantLocationsRepository;
import com.hamburger.texashamburgercompany.service.RestaurantLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class RestaurantLocationServiceImpl implements RestaurantLocationService {

    @Autowired
    private RestaurantLocationsRepository restaurantLocationsRepository;
    @Override
    public List<RestaurantLocations> getAllLocations() {
        return restaurantLocationsRepository.findAll();
    }

    @Override
    public RestaurantLocations getRestaurantById(Long id) {
        return restaurantLocationsRepository.findById(id).orElse(null);
    }

    @Override
    public RestaurantLocations addOrUpdateLocation(RestaurantLocations restaurantLocation) {
        return restaurantLocationsRepository.save(restaurantLocation);
    }

    @Override
    public RestaurantLocations deleteLocation(Long id) throws Exception {
        RestaurantLocations deletedLocation;
        deletedLocation = restaurantLocationsRepository.findById(id).orElse(null);

        if(deletedLocation==null) {
            throw new Exception("restaurant not available");
        } else {
            restaurantLocationsRepository.deleteById(id);
        }
        return deletedLocation;
    }

    @Override
    public List<RestaurantLocations> getRestaurantsWithSorting(String field) {
        return restaurantLocationsRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<RestaurantLocations> getRestaurantsWithPagination(int offset, int pageSize) {
        return restaurantLocationsRepository.findAll(PageRequest.of(offset,pageSize));
    }
}
