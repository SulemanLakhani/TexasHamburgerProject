package com.hamburger.texashamburgercompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamburger.texashamburgercompany.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
