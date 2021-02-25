package com.example.bagsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Entity
public class Bag extends BaseEntity {

	@Column(nullable = false)
	private Integer weight; 
	
	@Column(name = "bag_hxw",nullable = false)
	private Integer bagTotalWidthHeightSize;
	
	@Enumerated(EnumType.STRING)
	private BagStatus bagStatus; 

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getBagTotalWidthHeightSize() {
		return bagTotalWidthHeightSize;
	}

	public void setBagTotalWidthHeightSize(Integer bagTotalWidthHeightSize) {
		this.bagTotalWidthHeightSize = bagTotalWidthHeightSize;
	}

	public Bag(Integer weight, Integer bagTotalWidthHeightSize, BagStatus bagStatus) {
		super();
		this.weight = weight;
		this.bagTotalWidthHeightSize = bagTotalWidthHeightSize;
		this.bagStatus = bagStatus;
	}

	public Bag() {
		super();
	} 
	
	
	
	
	
	
	
	
	
}
