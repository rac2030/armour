package com.ihsanobed.Authentication;

public interface LoginFunction {

	public boolean logIn(String user);
	
	public boolean logOut();
	
	public boolean isLogin();
		
	public String getLoginUser();

}// end of LoginFunction
