package com.hamburger.texashamburgercompany.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private RestaurantLocations location;

	@Column(nullable = false)
	private LocalDate orderDate;

	@OneToOne
	private Items items;

	@OneToOne
	private Users user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestaurantLocations getLocation() {
		return location;
	}

	public void setLocation(RestaurantLocations location) {
		this.location = location;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Orders() {
		super();
	}

	public Orders(Long id, RestaurantLocations location, LocalDate orderDate, Items items, Users user) {
		super();
		this.id = id;
		this.location = location;
		this.orderDate = orderDate;
		this.items = items;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", location=" + location + ", orderDate=" + orderDate + ", items=" + items
				+ ", user=" + user + "]";
	}

}
