package com.ihsanobed.Authentication;

import javax.servlet.http.HttpSession;

public final class GaeAuthentication implements LoginFunction{
	
	private String user;
	
	private HttpSession session;
	
	public GaeAuthentication(HttpSession session){
				
		this.session = session;
		
		this.user = (String)this.session.getAttribute("user");
		
	}// end of GaeAuthentication

	@Override
	public boolean isLogin() {
		
		String userSession = (String)this.session.getAttribute("user");
				
		if(userSession == null){
			
			return false;
			
		}// no user login
		
		else if (userSession.equals(this.user)){
			
			return true;
			
		}// end of if statement which user does login
		
		else{
			
			return false;
			
		}// end of else which user does not login
		
	}// end of isLogin
	
	/*
	 * public boolean logIn(String user)
	 * (non-Javadoc)
	 * @see com.ihsanobed.Authentication.LoginFunction#logIn(java.lang.String)
	 * @param String to pass the user name 
	 * @return false if the user is already logged in 
	 * @return true if the user is the first time trying to login 
	 * 
	 */
	
	@Override
	public boolean logIn(String user) {
		
		if(this.isLogin()){
			return false;
		}
		else{
			this.session.setAttribute("user", user);
			this.user = user;
			return true;
		}
		
	}// end of logIn
	
	@Override
	public boolean logOut() {
		
		if(this.isLogin()){
			
			this.session.removeAttribute("user");
			
			this.user = null;
			
			return true;
			
		}// end of if statement "user has just logged out" 
		else{
			
			return false;
			
		}// user is not logged in before 
		
	}// end of logOut

	
	@Override
	public String getLoginUser() {
		
		return (String)this.session.getAttribute("user");
		
	}// end of getLoginUser
	
}// end of class GaeAuthentication
