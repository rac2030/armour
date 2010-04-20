package com.ihsanobed.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class SendPasswordAtUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String HTML = 
			"<!doctype html><html><head>" +
			" <title>Sending an Email</title>" + 
			"</head>" + 
			"<body>You password has been sent</body>" + 
			"</html>";// end of the HTML String body 
		
		new SendMailToUser("info@rrcb.de");
		
		response.getWriter().print(HTML);
	}// end of the HttpServlet
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}// end of doPost
	
}// end of HttpServlet class
