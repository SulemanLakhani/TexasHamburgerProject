package com.hamburger.texashamburgercompany.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamburger.texashamburgercompany.model.Items;
import com.hamburger.texashamburgercompany.model.Orders;
import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import com.hamburger.texashamburgercompany.model.Users;
import com.hamburger.texashamburgercompany.repository.OrderItemsRepository;
import com.hamburger.texashamburgercompany.repository.OrdersRepository;
import com.hamburger.texashamburgercompany.repository.RestaurantLocationsRepository;
import com.hamburger.texashamburgercompany.repository.UsersRepository;

@RestController
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderItemsRepository itemRepo;

	@Autowired
	private RestaurantLocationsRepository restRepository;

	@Autowired
	private UsersRepository usersRepository;

	@PostMapping("/order/{itemId}/{locId}/{userId}")
	public Orders addOrder(@RequestBody Orders orders, @PathVariable("itemId") Long itemId,
			@PathVariable("locId") Long locId, @PathVariable("userId") Long userId) {

		Optional<Items> item = itemRepo.findById(itemId);

		if (item.isEmpty()) {
			throw new RuntimeException("itemId is invalid");
		}
		Items items = item.get();
		
		//location id checking
		Optional<RestaurantLocations> rest = restRepository.findById(locId);

		if (rest.isEmpty()) {
			throw new RuntimeException("Location is invalid");
		}
		RestaurantLocations location = rest.get();
		
		//users id checking
				Optional<Users> user = usersRepository.findById(userId);

				if (user.isEmpty()) {
					throw new RuntimeException("User is invalid");
				}
				Users users = user.get();
				
				Orders order = new Orders();
				order.setItems(items);
				order.setLocation(location);
				order.setUser(users);
				order.setOrderDate(LocalDate.now());
			 return	ordersRepository.save(order);
	}

	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return ordersRepository.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Orders getOrderById(@RequestBody @PathVariable("id") Long id) {
		return ordersRepository.getReferenceById(id);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public Orders deleteOrderById(@PathVariable("id") Long id) {
		Optional<Orders> opt = ordersRepository.findById(id);

		if (opt.isEmpty()) {
			throw new RuntimeException("Id is not Valid");
		}
		Orders order = opt.get();
		ordersRepository.delete(order);
		return order;
		
	}
}
