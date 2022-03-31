package com.lab2.alugueldeautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String brand;
	private String model;
	private int year;
	private float dailyValue;
	private String owner;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(float dailyValue) {
		this.dailyValue = dailyValue;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Vehicle() {
		
	}
	
	public Vehicle(String brand, String model, int year, float dailyValue, String owner) {
		super();
		setBrand(brand);
		setModel(model);
		setYear(year);
		setDailyValue(dailyValue);
		setOwner(owner);
	}
	
	
	
	
	

}
