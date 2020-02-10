package com.api.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_state")
public class ItemState implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
	private int id;
	@Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT true")
	private boolean isActive;
	//@Column(name = "change_by")
	@ManyToOne
	@JoinColumn(name = "changed_by", nullable = true)
	private User changedBy;
	@Column
	private String reason;
	
	public ItemState() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
