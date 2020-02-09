package com.api.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String country;
	@Column
	@ManyToMany
	@JoinTable(name = "item_supplier"
	, joinColumns=@JoinColumn(name = "id_item")
	, inverseJoinColumns=@JoinColumn(name = "id_supplier"))
	@JoinColumn(name = "id", nullable = true)
	private List<Item> items;
	
	public Supplier() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
