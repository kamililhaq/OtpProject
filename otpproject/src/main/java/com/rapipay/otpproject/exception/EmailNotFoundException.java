package com.rapipay.otpproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmailNotFoundException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public EmailNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}

}
