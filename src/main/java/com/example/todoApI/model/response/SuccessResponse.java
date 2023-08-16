package com.example.todoApI.model.response;

public class SuccessResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccessResponse(String message) {
		super();
		this.message = message;
	}

	public SuccessResponse() {
		super();
	}

	@Override
	public String toString() {
		return "SuccessResponse [message=" + message + "]";
	}
}