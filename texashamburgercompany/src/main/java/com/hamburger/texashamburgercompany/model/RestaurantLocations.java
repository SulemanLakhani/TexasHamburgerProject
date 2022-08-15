package com.hamburger.texashamburgercompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class RestaurantLocations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String locationName;

	@Column(nullable = false)
	private String streetName;

	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private int zipcode;

	@Override
	public String toString() {
		return "RestaurantLocations [id=" + id + ", locationName=" + locationName + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}

	public RestaurantLocations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantLocations(Long id, String locationName, String streetName, String city, String state,
			int zipcode) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
