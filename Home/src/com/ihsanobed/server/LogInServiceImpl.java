package com.ihsanobed.server;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.ihsanobed.Authentication.Authentication;
import com.ihsanobed.Authentication.GaeAuthentication;
import com.ihsanobed.Authentication.HttpAuthentication;
import com.ihsanobed.client.LogInService;
import com.ihsanobed.shared.LoginUser;
import com.ihsanobed.shared.Verification;

@SuppressWarnings("serial")
public class LogInServiceImpl extends RemoteServiceServlet implements LogInService{
	

	@Override
	public String sendUserInfo(LoginUser user) throws IllegalArgumentException {
		
		String messageBack="Server says: Invalid User or Pass";
		
		if(Verification.isValidEmail(user.getUser()) && Verification.isValidPass(user.getPass()) ) {
			
			String userID = user.getUser();
			
			HttpSession session = this.getThreadLocalRequest().getSession();
			
			Authentication authen = new HttpAuthentication (new GaeAuthentication(session));
			
			LoginUserRecord userRecord = new LoginUserRecordAsJDO();
			
			if (userRecord.verifyLoginUserAtPassword(user)){
				
				if (authen.logIn(userID)){
					
					messageBack = "Server says: Welcome " + authen.getLoginUser();
					
				}
				else{
					
					messageBack = "Server says: You are logged in before with " + authen.getLoginUser();
					
				}
				
			}// end of if for Verification of user in DB
			
			
			else{
				
				if(authen.isLogin())
					
				messageBack = "Server says: You are logged in before with " 
								+ authen.getLoginUser() + " and Wrong pass or user";
				
				else{
					
					messageBack = "Server says: Wrong Pass or User";
					
				}
				
			}// end of else

		}// end of if general verification 
		
		return messageBack;
		
	}// end of sendUserInfo "Function called by client"

}// end of SignUpServiceImpl
