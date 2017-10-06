package com.cg.day3session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WelcomeCookie")
public class WelcomeCookie extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Cookie ck[]=request.getCookies();
		for(Cookie c:ck)
		{
			out.print(c.getName()+"<br>");
			out.print(c.getValue()+"<br>");

		}
	
	}

}
