package com.ihsanobed.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.ihsanobed.shared.LoginUser;
public class LogIn implements EntryPoint {
	
	private LoginUser user = new LoginUser();
	
	private final LogInServiceAsync sendingService = GWT
	.create(LogInService.class);

	@Override
	public void onModuleLoad() {
		
		final DockLayoutPanel panelDesign = new DockLayoutPanel(Unit.EM);
		final RootLayoutPanel rootPanel = RootLayoutPanel.get();
		
		final HTML header= new HTML("The Head goes here");
		final HTML footer= new HTML("www.ihsanobed.com");
		
		final VerticalPanel mainPanel = new VerticalPanel();
		
		final TabPanel authenTap = new TabPanel();
		
		final VerticalPanel loginForm = new VerticalPanel();
		final VerticalPanel forgetPass = new VerticalPanel();
		
		final Label des = new Label("Login Page");
		
		final Label userName = new Label("Username");
		final TextBox userInputText = new TextBox();
		final Label passWord = new Label("Password");
		final PasswordTextBox passwordInput = new PasswordTextBox();
		final Button loginButton = new Button("Login");
		
		final Label sendEmailText = new Label("This well send your password to your email");
		final Label emailText = new Label("Your email");
		final TextBox email = new TextBox();
		final Button sendEmail = new Button ("Send");
		
		
		loginForm.add(userName);
		loginForm.add(userInputText);
		loginForm.add(passWord);
		loginForm.add(passwordInput);
		loginForm.add(loginButton);
		
		forgetPass.add(sendEmailText);
		forgetPass.add(emailText);
		forgetPass.add(email);
		forgetPass.add(sendEmail);
		
		authenTap.add(loginForm, "Login");
		authenTap.add(forgetPass, "Send Password");
		authenTap.selectTab(0);
		
		mainPanel.add(des);
		mainPanel.add(authenTap);
		
		panelDesign.addNorth(header, 2);
		panelDesign.addSouth(footer, 2);
		panelDesign.add(mainPanel);
		
		rootPanel.add(panelDesign);
		
		
		// Create a handler for the userInsert, passInsert and signUp
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				
				sendFieldsToServer();
				
			}// end of onClick

			public void onKeyUp(KeyUpEvent event) {
				
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					
					sendFieldsToServer();
					
				}// end of if statement 
				
			}// end of onKeyUp

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendFieldsToServer() {
				/*
				 * Here we can add any Verification 
				 */
				//signUp.setEnabled(false);
				
				// Initial the email property of the UserInfo object by entry from the user 
				user.setUser(userInputText.getText());
				// Initial the password property of the UserInfo object by entry from the user 
				user.setPass(passwordInput.getText());
				
				// Call the AJAX function to send the Object to the server and receive the outcome
				sendingService.sendUserInfo(user,
						
						//Second parameter which is the response from the server
						new AsyncCallback<String>() {
					
							public void onFailure(Throwable caught) {
								header.setText(caught.getMessage());
								// Show the RPC error message to the user
								
							}// end of onFailure

							public void onSuccess(String result) {
								
								header.setText("" + result);
								
							}// end of onSuccess
							
						});// end of sendUserInfo with inner class AsyncCallback<String>
				
			}//sendFieldsToServer
			
		}// end of inner class MyHandler
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Add a handler to send the Object to the server 
		MyHandler handler = new MyHandler();
		
		userInputText.addKeyUpHandler(handler);
		passwordInput.addKeyUpHandler(handler);
		loginButton.addClickHandler(handler);


	}// end of the onModuleLoad()

}// end of the EntryPoint 
