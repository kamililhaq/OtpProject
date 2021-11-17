package com.rapipay.otpproject.entity;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email{
	@Id
	String email;
	int id;
	LocalDateTime generatedTime;
	LocalDateTime expiryTime;
	int otp;

	public Email(String email, int otp, int id) {
		super();
		this.email = email;
		this.generatedTime=null;
		this.expiryTime=null;
		this.otp = otp;
		this.id=id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getGeneratedTime() {
		return generatedTime;
	}
	public void setGeneratedTime() {
		this.generatedTime = LocalDateTime.now();
	}
	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime() {
		this.expiryTime = LocalDateTime.now().plus(Duration.of(1, ChronoUnit.MINUTES));
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp() {
		
	    this.otp =generateOtp();
	}
	public Email() {
		super();
		
	} 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
   
	public int generateOtp() {
		
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return number;
	}
}
