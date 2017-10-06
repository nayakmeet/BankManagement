package com.cg.day3session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		long l=session.getCreationTime();											//mtt question
		System.out.println(l);
		String u=(String) session.getAttribute("user");									//httpesession part.
   		String e=(String) session.getAttribute("email");
   		out.println(u);																//+"<br>"
   		out.println(e);
   		System.out.println(session.getLastAccessedTime());						//mtt question
   		
		
	
		
		
		
		
			
	}

}
