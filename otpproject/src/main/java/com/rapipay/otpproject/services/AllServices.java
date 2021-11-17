package com.rapipay.otpproject.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rapipay.otpproject.dao.EmailOtp;
import com.rapipay.otpproject.entity.Email;
import com.rapipay.otpproject.exception.EmailNotFoundException;
import com.rapipay.otpproject.exception.InvalidOTPException;
import com.rapipay.otpproject.exception.OTPExpireException;
import com.rapipay.otpproject.exception.ResourseNotFoundException;

public interface AllServices {
	
	 List<Email> getAllEmail();
	
	 Email getByEmail(String email) throws ResourseNotFoundException ;
	 

		ResponseEntity<HttpStatus> addEmail(Email email) throws EmailNotFoundException ;

		ResponseEntity<HttpStatus> OtpValidate(EmailOtp eo) throws ResourseNotFoundException, OTPExpireException, InvalidOTPException;
	 
	 
	 
	 
	
	

}

