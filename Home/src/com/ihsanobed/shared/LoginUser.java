package com.ihsanobed.shared;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LoginUser implements java.io.Serializable {
	
	@PrimaryKey
	private String user;
	
	@Persistent
	private String pass;
	
	public void setUser(String user){
		
		this.user = user;
		
	}// end of setUser
	
	public String getUser(){
		
		return this.user;
		
	}// end of getUser
	
	public void setPass(String pass){
		
		this.pass = pass;
		
	}// end of setPass
	
	public String getPass(){
		
		return this.pass;
		
	}// end of getPass

}// end of LoginUser
