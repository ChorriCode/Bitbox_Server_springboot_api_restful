package com.api.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@Column
	private int id;
	@Column(name = "item_code")
	private int itemCode;
	@Column
	private String description;
	@Column
	private float price;
	//@Column
	@OneToOne
	@JoinColumn(name = "state", nullable = false)
	private ItemState state;
	@ManyToMany(mappedBy = "items")
	private List<Supplier> suppliers;
	@Column(name="price_reduction")
	@OneToMany
	private List<PriceReduction> pricesReduction;
	//@Column(name = "creator_user")
	@OneToOne
	@JoinColumn(name = "creator_user", nullable = false)
	private User creatorUser;
	
	public Item() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ItemState getState() {
		return state;
	}

	public void setState(ItemState state) {
		this.state = state;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<PriceReduction> getPricesReduction() {
		return pricesReduction;
	}

	public void setPricesReduction(List<PriceReduction> pricesReduction) {
		this.pricesReduction = pricesReduction;
	}

	public User getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
	}
	
	
	

}
