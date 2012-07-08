package com.example.registration.exception;

public class RegistrationException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public RegistrationException(String code) {
		this.code = code;
	}


	public RegistrationException(Throwable throwable){
		super(throwable);
	}

	public String getCode() {
		return code;
	}

}
