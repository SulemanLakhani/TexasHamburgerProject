package com.hamburger.texashamburgercompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLocationsRepository extends JpaRepository<RestaurantLocations, Long>{

}
