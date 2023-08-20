package com.example.todoApI.model;

public class NullType {

	private int status;
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NullType(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public NullType() {
		super();
	}

	@Override
	public String toString() {
		return "NullType [status=" + status + ", message=" + message + "]";
	}

}