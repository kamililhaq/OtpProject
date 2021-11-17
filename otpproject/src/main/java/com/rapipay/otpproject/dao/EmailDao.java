package com.rapipay.otpproject.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapipay.otpproject.entity.Email;

import javax.persistence.*;


public interface EmailDao extends JpaRepository<Email, String>{

}
