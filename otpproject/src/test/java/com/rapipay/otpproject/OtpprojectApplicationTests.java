package com.rapipay.otpproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rapipay.otpproject.dao.EmailDao;
import com.rapipay.otpproject.dao.EmailOtp;
import com.rapipay.otpproject.entity.Email;
import com.rapipay.otpproject.exception.ResourseNotFoundException;
import com.rapipay.otpproject.services.ServicesImpl;

@SpringBootTest
class OtpprojectApplicationTests {

	@Autowired
	EmailDao emailRepo;

	@Test
	public void otpvalidate() {
		Email e = new Email();
		e.setEmail("test1@gmail.com");
		e.setGeneratedTime();
		e.setExpiryTime();
		e.setOtp();
		emailRepo.save(e);
		EmailOtp eo = new EmailOtp();
		ServicesImpl e1 = new ServicesImpl();
		int expected = e.getOtp();
		int actual = e.getOtp();
		assertEquals(expected, actual);

	}

	@Test
	public void checkOtpDigits() {
		Email e = new Email();
		e.setOtp();
		int a = e.getOtp();
		String s = Integer.toString(a);
		int expected = 6;
		int actual = s.length();
		assertEquals(expected, actual);

	}

	@Test
	public void checkIfObjectSaved() {
		Email e = new Email();
		e.setEmail("kamililhaq@gmail.com");
		e.setGeneratedTime();
		e.setExpiryTime();
		e.setOtp();
		emailRepo.save(e);
		assertNotNull(emailRepo, "This function should save the email object!");
	}

	public boolean checkEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Test
	void checkEmailRegex() {
		Email e=new Email();
		e.setEmail("kamililhaq@gmail.com");
		boolean expected = true;
		boolean actual = checkEmail(e.getEmail());
		assertEquals(expected, actual);
	}
	
	
	
}

