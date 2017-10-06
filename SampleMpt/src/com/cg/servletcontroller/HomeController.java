package com.cg.servletcontroller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.beancontroller.CustomerBean;
import com.cg.service.customer.CustomerImpl;
import com.cg.service.customer.ICustomer;

@WebServlet("*.obj")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBean bean=new CustomerBean();
		ICustomer service=new CustomerImpl();
		String path= request.getServletPath();
		String target = null;
		switch(path)
			{
		case "/customer.obj": 
			String consumerNo=request.getParameter("Number");
			int consno=Integer.parseInt(consumerNo);
			String custName=request.getParameter("Name");
			String emailId=request.getParameter("Email");
			String phoneNo=request.getParameter("phone");
			
			bean.setConsumerNo(consno);
			bean.setCustomerName(custName);
			bean.setEmailId(emailId);
			bean.setPhoneNo(phoneNo);
		
			int res = 0;
			try {
				res = service.addDetails(bean);
				System.out.println(res);
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			
			if(res==1)
			{
				target="Success.html";
			}
			else
			{
				target="Error.html";
			}
			break;
			}
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
