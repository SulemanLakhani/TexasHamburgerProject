package com.hamburger.texashamburgercompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamburger.texashamburgercompany.model.Items;

public interface OrderItemsRepository extends JpaRepository<Items, Long>{

}
