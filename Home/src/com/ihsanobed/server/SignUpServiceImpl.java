package com.ihsanobed.server;

import com.ihsanobed.client.SignUpService;
import com.ihsanobed.shared.LoginUser;
import com.ihsanobed.shared.Verification;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class SignUpServiceImpl extends RemoteServiceServlet implements SignUpService{

	@Override
	public String sendUserInfo(LoginUser user) throws IllegalArgumentException {
		
		if (Verification.isValidEmail(user.getUser()) && Verification.isValidPass(user.getPass())){
			
			LoginUserRecord userRecord = new LoginUserRecordAsJDO();
			
				if(userRecord.createLoginUser(user)){
					return "User created";
					
				}// end of creating case
				
				else {
					
					return "User already existed";

				}// end of else for existed user
			
		}// end of if statement "valid case"
		
		else{
			
			return "invalid email " + user.getUser();
			
		}// end of else "invalid case"
		
	}// end of sendUserInfo "Function called by client"

}// end of SignUpServiceImpl
