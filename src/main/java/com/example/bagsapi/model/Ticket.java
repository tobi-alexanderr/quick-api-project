package com.example.bagsapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Ticket extends BaseEntity{

	@ManyToOne
	private User user; 
	
	@OneToMany
	private List<Bag> bags; 
	
	@NotBlank
	private String Destination; 
	
	@NotBlank
	private String Origin;

	public Ticket(User user, List<Bag> bags,  String destination,  String origin) {
		super();
		this.user = user;
		this.bags = bags;
		Destination = destination;
		Origin = origin;
	}

	public Ticket() {
		super();
	} 
	
	
	
	
	
	
}
