package com.ihsanobed.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.ihsanobed.shared.LoginUser;

public interface LogInServiceAsync {

	void sendUserInfo(LoginUser user, AsyncCallback<String> callback) throws IllegalArgumentException;

}// end of LogInServiceAsync
