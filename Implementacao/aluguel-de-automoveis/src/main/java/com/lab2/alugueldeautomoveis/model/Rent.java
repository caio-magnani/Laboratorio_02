package com.lab2.alugueldeautomoveis.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rent")
public class Rent {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 private LocalDateTime datePickUp;
	 private LocalDateTime dateDelivey;
	 
	 @OneToOne
	 @JoinColumn(name = "vehicles_id")
	 private Vehicle vehicles;
	 
	 public Rent(Vehicle vehicles) {
		super();
		this.vehicles = vehicles;
	}


	public Rent() {
		 
	 }


	public LocalDateTime getDatePickUp() {
		return datePickUp;
	}


	public void setDatePickUp(LocalDateTime datePickUp) {
		this.datePickUp = datePickUp;
	}


	public LocalDateTime getDateDelivey() {
		return dateDelivey;
	}


	public void setDateDelivey(LocalDateTime dateDelivey) {
		this.dateDelivey = dateDelivey;
	}


	public Vehicle getVehicles() {
		return vehicles;
	}


	public void setVehicles(Vehicle vehicles) {
		this.vehicles = vehicles;
	}
	
	
	 
}
