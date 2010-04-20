package com.ihsanobed.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ihsanobed.shared.LoginUser;

@RemoteServiceRelativePath("login.ajax")
public interface LogInService extends RemoteService {
	
	String sendUserInfo(LoginUser user) throws IllegalArgumentException;
	
}// end of SignUpService

