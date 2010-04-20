package com.ihsanobed.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.ihsanobed.shared.LoginUser;


@SuppressWarnings("deprecation")
public class SignUp implements EntryPoint {
	
	private LoginUser user = new LoginUser();
	
	
	private final SignUpServiceAsync sendingService = GWT
	.create(SignUpService.class);

	@Override
	public void onModuleLoad() {
		
		final VerticalPanel main = new VerticalPanel ();
		
		final Label outcome = new Label();
		
		final Label userText = new Label ("Input Username");
		final TextBox userInsert = new TextBox();
		userInsert.setText("user@mail.com");
		userInsert.addFocusListener(new FocusListener(){

			@Override
			public void onFocus(Widget sender) {
				
				userInsert.setText("");				
			}

			@Override
			public void onLostFocus(Widget sender) {
				/*
				
				if(Verification.isValidEmail(userInsert.getText())){
					outcome.setText("Correct email");
				}
				
				
				else{
					outcome.setText("not correct email");
					userInsert.setFocus(true);
				}
				*/
				outcome.setText("Your User "+ userInsert.getText());
								
			}// end of onLostFocus
			
		});// end of addFocusListener inner class
		
		final Label passText = new Label("Input Password");
		final PasswordTextBox passInsert = new PasswordTextBox();
		
		final Button signUp = new Button ("Sign Up");
		
		main.add(outcome);
		main.add(userText);
		main.add(userInsert);
		main.add(passText);
		main.add(passInsert);
		main.add(signUp);
		
		
		main.setBorderWidth(3);
		userInsert.setFocus(true);
		
		RootPanel.get().add(main);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
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
				user.setUser(userInsert.getText());
				// Initial the password property of the UserInfo object by entry from the user 
				user.setPass(passInsert.getText());
				
				// Call the AJAX function to send the Object to the server and receive the outcome
				sendingService.sendUserInfo(user,
						
						//Second parameter which is the response from the server
						new AsyncCallback<String>() {
					
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								
							}// end of onFailure

							public void onSuccess(String result) {
								outcome.setText(result);
								
							}// end of onSuccess
							
						});// end of sendUserInfo with inner class AsyncCallback<String>
				
			}//sendFieldsToServer
			
		}// end of inner class MyHandler
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Add a handler to send the Object to the server 
		MyHandler handler = new MyHandler();
		
		// add the handler for the click event
		signUp.addClickHandler(handler);
		
		// add the handler for the enter key press
		userInsert.addKeyUpHandler(handler);
		passInsert.addKeyUpHandler(handler);
		

	}// end of onModuleLoad

}// end of class
