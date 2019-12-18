package com.ding.core;

public class BusinessRuntimeException extends RuntimeException{
	private static final long	serialVersionUID	= -197689979445010501L;
	private String				code;
	private String				message;
	
	public BusinessRuntimeException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	public BusinessRuntimeException(String message) {
		super();
		this.message = message;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
