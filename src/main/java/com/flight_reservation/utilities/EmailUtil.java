package com.flight_reservation.utilities;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
  JavaMailSender javaMailSender;
  public void sendEmail(String toAddress, String filePath) {
	  MimeMessage message = javaMailSender.createMimeMessage();
	  try{
		  MimeMessageHelper helper=new MimeMessageHelper(message,true);
		  helper.setTo(toAddress);
		  helper.setText("Flight Booking Tickets");
		  helper.setSubject("Find the attatchment");
		  helper.addAttachment("Flight Booking Tickets", new File(filePath));
		  javaMailSender.send(message);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
