package com.cg.day3session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletCookie")
public class ServletCookie extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("uname");
   		String email=request.getParameter("email");
   		
		Cookie ck1 = new Cookie("user",user);
   		Cookie ck2 = new Cookie("email",email);
   		//adding cookie object in response.
   		
   		response.addCookie(ck1);
   		response.addCookie(ck2);
   		
   		RequestDispatcher rd=request.getRequestDispatcher("WelcomeCookie");
   		rd.forward(request, response);

	}

}
