package com.ihsanobed.Authentication;

public abstract class Authentication {
	
	protected LoginFunction type;
		
	public Authentication (LoginFunction type){
		
		this.type = type;
		
	}// end of Authentication
	
	public abstract boolean logIn(String user);
	
	public abstract boolean logOut();
	
	public abstract boolean isLogin();
	
	public String getLoginUser(){
		
		return this.type.getLoginUser();
	}
	
}// end of class Authentication
