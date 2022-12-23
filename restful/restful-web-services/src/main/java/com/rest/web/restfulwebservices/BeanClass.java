package com.rest.web.restfulwebservices;

public class BeanClass {

	private String message;

	public BeanClass(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BeanClass [message=" + message + "]";
	}
	
	
}
