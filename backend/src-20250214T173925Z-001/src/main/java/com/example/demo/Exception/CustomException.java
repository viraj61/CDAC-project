package com.example.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends RuntimeException{
	public CustomException(String msg) {
		super(msg);
	}

	@Override
    public String usernotfoundMessage() {
        return "User not found! Please check the user ID.";
    }

	@Override
    public String invalidorderMessage() {
        return "Invalid order: Total price must be greater than zero.";
    }

}
