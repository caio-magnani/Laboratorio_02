package com.lab2.alugueldeautomoveis.model;

public class Vehicle {
	private long id;
	private String brand;
	private String model;
	private int year;
	private double dailyValue;
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

	public double getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(double dailyValue) {
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
	
	public Vehicle(String brand, String model, int year, double dailyValue, String owner) {
		super();
		setBrand(brand);
		setModel(model);
		setYear(year);
		setDailyValue(dailyValue);
		setOwner(owner);
	}
	
	
	
	
	

}
