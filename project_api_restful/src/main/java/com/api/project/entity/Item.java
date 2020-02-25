package com.api.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item")
public class Item implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private int id;
	
	@Column(name = "item_code", unique = true, nullable = false)
	private int itemCode;
	
	@Column(nullable = false)
	private String description;
	
	@Column
	private float price;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name = "state", nullable = false)
	private ItemState state;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name = "item_supplier", 
	joinColumns = @JoinColumn(name = "id_item"),
	inverseJoinColumns = @JoinColumn(name = "id_supplier"))
	private List<Supplier> suppliers;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemPriceReduction", cascade = CascadeType.REMOVE)
	private List<PriceReduction> pricesReduction;
	
	
	@Column(name = "creation_at", insertable = false, updatable = false, columnDefinition="DATE DEFAULT CURRENT_TIMESTAMP")
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name = "register_byr")
	private User resgisterBy;
	
	
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	
	public void setSupplier(Supplier supplier) {
		this.suppliers.add(supplier);
	}


	public List<PriceReduction> getPricesReduction() {
		return pricesReduction;
	}

	public void setPricesReduction(List<PriceReduction> pricesReduction) {
		this.pricesReduction = pricesReduction;
	}



	public User getResgisterBy() {
		return resgisterBy;
	}

	public void setResgisterBy(User resgisterBy) {
		this.resgisterBy = resgisterBy;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", description=" + description + ", price=" + price
				+ ", suppliers=" + suppliers + ", creationDate=" + creationDate + "]";
	}
	
	
	

}
