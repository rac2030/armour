package com.ihsanobed.client;

import com.ihsanobed.shared.LoginUser;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SignUpServiceAsync {

	void sendUserInfo(LoginUser user, AsyncCallback<String> callback) throws IllegalArgumentException;

}// end of SignUpServiceAsync
