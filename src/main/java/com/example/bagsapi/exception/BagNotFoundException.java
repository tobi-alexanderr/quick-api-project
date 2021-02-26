package com.example.bagsapi.exception;

import lombok.Data;

@Data
public class BagNotFoundException extends RuntimeException{

	String id;

	public BagNotFoundException(String id) {
		this.id = id;
	}
}
