package com.api.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private int id;
	@Column(length = 100)
	private String name;
	@Column(length = 75)
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
