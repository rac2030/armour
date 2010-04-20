package com.ihsanobed.client;

import com.ihsanobed.shared.LoginUser;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("signup.ajax")
public interface SignUpService extends RemoteService {
	
	String sendUserInfo(LoginUser user) throws IllegalArgumentException;
	
}// end of SignUpService
