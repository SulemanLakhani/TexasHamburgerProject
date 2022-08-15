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

import com.hamburger.texashamburgercompany.model.Items;
import com.hamburger.texashamburgercompany.repository.OrderItemsRepository;

@RestController
public class ItemsController {
	
	@Autowired
	private OrderItemsRepository itemRepository;
	
	@PostMapping("/addOrUpdateItem")
	public Items addItems(@RequestBody Items item) {
		return itemRepository.save(item);
	}

	@GetMapping("/items")
	public List<Items> getItems() {
		return itemRepository.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Items getItemsByID(@RequestBody @PathVariable("id") Long id) {
		return itemRepository.getReferenceById(id);
	}
	
	@DeleteMapping("deleteItem/{id}")
	public Items deleteRestaurantById(@PathVariable("id") Long id) {

		Optional<Items> opt = itemRepository.findById(id);

		if (opt.isEmpty()) {
			throw new RuntimeException("Id is not Valid");
		}
		Items item = opt.get();
		itemRepository.delete(item);
		return item;
	}


}
