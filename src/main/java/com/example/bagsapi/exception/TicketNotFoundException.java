package com.example.bagsapi.exception;

import lombok.Data;

@Data
public class TicketNotFoundException extends RuntimeException{


	String id;

	public TicketNotFoundException(String id) {
		this.id = id;
	}

	
}
