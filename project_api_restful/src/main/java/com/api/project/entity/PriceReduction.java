package com.api.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="price_reduction")
public class PriceReduction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="reduce_price")
	private float reducedPrice;
	
	@Column(name="start_Date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "item_id")
	 @JsonBackReference
	 private Item itemPriceReduction;
	
	public PriceReduction() {
		
	}
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getReducedPrice() {
		return reducedPrice;
	}
	public void setReducedPrice(float reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Item getItemPriceReduction() {
		return itemPriceReduction;
	}


	public void setItemPriceReduction(Item itemPriceReduction) {
		this.itemPriceReduction = itemPriceReduction;
	}



	

}
