package com.ihsanobed.server;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailToUser {
	
	String to;     
    public SendMailToUser(String to) {
    	
    	String from="ihsanho@gmail.com";
    	
    	this.to = to;
    	
    	String msgBody = "Password is ......"; 
    	
    	Properties props = new Properties();
    	
        Session session = Session.getDefaultInstance(props, null);
    	
    	try {
    		
            Message msg = new MimeMessage(session);
            
            try {
				msg.setFrom(new InternetAddress(from, "no-reply@ihsanobed.com"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            try {
				msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress(this.to, ""));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            msg.setSubject("Request for your password");
            
            msg.setText(msgBody);
            
            Transport.send(msg);
    		

    	} catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        }

    	
    }// end of constructor 

}// end of class
