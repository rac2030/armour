package com.ihsanobed.server;

import javax.jdo.PersistenceManager;

import com.ihsanobed.shared.LoginUser;

public final class LoginUserRecordAsJDO implements LoginUserRecord{
	
	private PersistenceManager pm = PMF.get().getPersistenceManager();

	@Override
	public boolean createLoginUser(LoginUser user) {
		
		boolean status = false;
		
		if(this.isLoginUser(user.getUser()) == null){
			
			try{
				
				this.pm.makePersistent(user);
				
				status = true;
			
			}// end of try
		
			finally{
				
				this.pm.close();
				
			}// end of finally
			
		}// end of if statement for creation new user
		
		return status;
		
	}// end of createLoginUser

	@Override
	public boolean deleteLoginUserByUser(String user) {
		
		boolean status = false;
		// TODO Auto-generated method stub
		return status;
	}// end of deleteLoginUserByUser

	@Override
	public LoginUser isLoginUser(String user) {
		
		LoginUser existedUser = null;
		
		try {
			LoginUser res = this.pm.getObjectById(LoginUser.class, user);
			
			if (res.getUser().equals(user)){
				
				existedUser = res;
				
			}// end of statement 
			
		}// end of try
		
		catch(Throwable e){
			
			return null;
			
		}// end of catch
		
		return existedUser;
		
	}// end of isLoginUser

	@Override
	public boolean updateLoginUserAtPassword(String pass) {
		
		boolean status = false;

		return status;
		
	}// end of updateLoginUserByPass

	@Override
	public boolean verifyLoginUserAtPassword(LoginUser user) {
		
		//boolean status = false;
		
		LoginUser checkPass= this.isLoginUser(user.getUser()); 
		
		if (checkPass == null){
			
			return false;
			
		}// end of if statement which means no such user
		
		if(checkPass.getPass().equals(user.getPass())){
			
			return true;
			
		}// end of if statement for pass checking in case is true
		
		else {
			
			return false;
		}// end of if statement for pass checking in case is false
		
		//return status;
	}// end of verifyLoginUserPassword

	@Override
	public boolean verifyLoginUserUser(LoginUser user) {
		// this function will return true of false the user is login and verify by DB
		// this function is for prevent the user to login twice .
		
		// TODO Auto-generated method stub
		return false;
	}// end of verifyLoginUserPassword
	
}// end of class LoginUserRecordAsJDO
