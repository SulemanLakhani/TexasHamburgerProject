package com.hamburger.texashamburgercompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String itemDescription;
		
	@Column(nullable = false)
	private double itemPrice;

	
	public Items() {
		super();
	}

	public Items(Long id, String itemDescription, double itemPrice) {
		super();
		this.id = id;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemDescription=" + itemDescription + ", itemPrice=" + itemPrice + "]";
	}
}
