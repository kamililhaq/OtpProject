package com.rapipay.otpproject.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rapipay.otpproject.dao.EmailDao;
import com.rapipay.otpproject.dao.EmailOtp;
import com.rapipay.otpproject.entity.Email;
import com.rapipay.otpproject.exception.EmailNotFoundException;
import com.rapipay.otpproject.exception.InvalidOTPException;
import com.rapipay.otpproject.exception.OTPExpireException;
import com.rapipay.otpproject.exception.ResourseNotFoundException;
import com.rapipay.otpproject.services.AllServices;
@RestController
public class OTPController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OTPController.class);
	
	@Autowired
	  private JavaMailSender javaMailSender;

	@Autowired
	private AllServices allservices;

	
	@CrossOrigin
	@GetMapping("/email")
	public List<Email> getAllEmail(){
		
		
		return allservices.getAllEmail();
	}
	
	@CrossOrigin
	@GetMapping("/email/{email}")
	public Email getByEmail(@PathVariable String email ) throws ResourseNotFoundException {
		
		LOGGER.info("GetMapping method accessed!");
		return allservices.getByEmail(email);
		
	}

	@CrossOrigin
	@PostMapping("/email")
	public ResponseEntity<HttpStatus> addEmail(@RequestBody Email email ) throws EmailNotFoundException {
		
		email.setGeneratedTime();
		email.setExpiryTime();
		email.setOtp();
		LOGGER.info("PostMapping method accessed!");
		return this.allservices.addEmail(email);
	}	
	@CrossOrigin
	@PostMapping("/otp-validate")
	public ResponseEntity<HttpStatus> otpValidate(@RequestBody EmailOtp eo) throws ResourseNotFoundException,OTPExpireException,InvalidOTPException
	{
		LOGGER.info("Validate method accessed!");
		return allservices.OtpValidate(eo);
	}
}
