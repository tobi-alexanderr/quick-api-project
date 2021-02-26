package com.example.bagsapi.exception;


import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{

	String id;

	public UserNotFoundException(String id) {
		this.id = id;
	}
}
