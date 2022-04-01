package com.lab2.alugueldeautomoveis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tb_rent_tickets")
public class RentTickets {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	 @OneToOne
	 @JoinColumn(name = "rent_tickets_id")
	 	private Rent rent;	
	 
	private String status;
	
	@OneToOne
	@JoinColumn(name = "enterprise_id")
	private EnterpriseUser assignee;
	private String contract;
	
	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public EnterpriseUser getAssignee() {
		return assignee;
	}

	public void setAssignee(EnterpriseUser assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public RentTickets(Rent rent, String status, EnterpriseUser assignee, String contract) {
		super();
		this.rent = rent;
		this.status = status;
		this.assignee = assignee;
		this.contract = contract;
	}

	public RentTickets() {
		
	}
}
