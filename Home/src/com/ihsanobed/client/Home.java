package com.ihsanobed.client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.ui.Anchor;

import com.google.gwt.user.client.ui.HTML;

import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint {


	public void onModuleLoad() {
		HTML des = new HTML("<h1>Ihsan Obed coming soon</h1>");
		
		Anchor loginLink = new Anchor();
		Anchor sinupLink = new Anchor();
		Anchor sendmail = new Anchor();
		
		loginLink.setHref("/en-US/login.gwt");
		loginLink.setHTML("<h2>LogIn Page</h2>");

		
		sinupLink.setHref("/en-US/signup.gwt");
		sinupLink.setHTML("<h2>Sign Up Page</h2>");
		
		sendmail.setHref("/en-US/sendpass.dll");
		sendmail.setHTML("<h2>Send your password to your email");
			
		
		
		
		RootPanel.get().add(des);
		RootPanel.get().add(sinupLink);
		RootPanel.get().add(loginLink);
		RootPanel.get().add(sendmail);
		
	}
}
