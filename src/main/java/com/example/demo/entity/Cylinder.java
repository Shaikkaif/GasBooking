package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Cylinder {
	
	public Cylinder() {
		super();
	}
	public Cylinder(long cylinderId, String cylinderType, String cylinderName, float cylinderWeight, String strapColour,
			float cylinderPrice) {
		super();
		this.cylinderId = cylinderId;
		this.cylinderType = cylinderType;
		this.cylinderName = cylinderName;
		this.cylinderWeight = cylinderWeight;
		this.strapColour = strapColour;
		this.cylinderPrice = cylinderPrice;
	}
	@Id
	private long cylinderId;
	private String cylinderType;
	private String cylinderName;
	private float cylinderWeight;
	private String strapColour;
	private float cylinderPrice;
	public long getCylinderId() {
		return cylinderId;
	}
	public void setCylinderId(long cylinderId) {
		this.cylinderId = cylinderId;
	}
	public String getCylinderType() {
		return cylinderType;
	}
	public void setCylinderType(String cylinderType) {
		this.cylinderType = cylinderType;
	}
	public String getCylinderName() {
		return cylinderName;
	}
	public void setCylinderName(String cylinderName) {
		this.cylinderName = cylinderName;
	}
	public float getCylinderWeight() {
		return cylinderWeight;
	}
	public void setCylinderWeight(float cylinderWeight) {
		this.cylinderWeight = cylinderWeight;
	}
	public String getStrapColour() {
		return strapColour;
	}
	public void setStrapColour(String strapColour) {
		this.strapColour = strapColour;
	}
	public float getCylinderPrice() {
		return cylinderPrice;
	}
	public void setCylinderPrice(float cylinderPrice) {
		this.cylinderPrice = cylinderPrice;
	}
	

}