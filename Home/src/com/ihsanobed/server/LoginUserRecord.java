package com.ihsanobed.server;

import com.ihsanobed.shared.LoginUser;

public interface LoginUserRecord {
	
	public boolean createLoginUser(LoginUser user);
	
	public boolean deleteLoginUserByUser(String user);
	
	public boolean updateLoginUserAtPassword(String pass);
	
	public LoginUser isLoginUser(String user);
	
	public boolean verifyLoginUserUser(LoginUser user);
	
	public boolean verifyLoginUserAtPassword(LoginUser user);

}// end of LoginUserAsRecord
