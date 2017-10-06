package com.cg.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/FilterExample")
public class FilterExample implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		PrintWriter out=response.getWriter();
		String password=request.getParameter("pwd");
		if(password.equals("admin"))
		{
			//chain.doFilter(request,response);
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
			rd.include(request,response);
		}
		else
		{
		
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
			out.print("Sorry your password is incorrect");
		}
		
	}


	@Override
	public void destroy() {
		
	}

	
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
