package com.hamburger.texashamburgercompany.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

}
