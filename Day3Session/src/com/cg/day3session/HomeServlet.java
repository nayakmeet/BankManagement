package com.cg.day3session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

       	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		
       		String user=request.getParameter("uname");
       		String email=request.getParameter("email");
       		
       	
       		HttpSession session=request.getSession(true);					//httpSession part.
       		session.setAttribute("user", user);
       		session.setAttribute("email", email);
       		
       		RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
       		rd.forward(request, response);

   	}

}
