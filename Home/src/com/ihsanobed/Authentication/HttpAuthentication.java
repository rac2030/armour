package com.ihsanobed.Authentication;

public class HttpAuthentication extends Authentication{
		
	public HttpAuthentication(LoginFunction type){
		
		super(type);
		
	}// end of HttpAuthentication
	
	@Override
	public boolean isLogin(){
		
		return type.isLogin();

	}// end of doIsLogin

	@Override
	public boolean logIn(String user) {
		
		return type.logIn(user);
		
	}// end of doLogin()

	@Override
	public boolean logOut() {
		
		return type.logOut();
	
	}// end of doIsLogin()
	
	public void setAuthentication (LoginFunction type){
		
		this.type = type;
		
	}// end of switchAthenticationTo
	
}// end of class HttpAuthentication
