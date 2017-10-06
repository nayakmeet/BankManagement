package com.cg.servlet;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.BankBean;
import com.cg.service.BankManageServiceImpl;
import com.cg.service.IBankservice;




@WebServlet("*.obj")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BankBean bean=new BankBean();
		IBankservice service=new BankManageServiceImpl();
		String path= request.getServletPath();
		String target=null;
	
	
		
		switch(path)
			{
		case "/add.obj":
		{
			target="NewCustomer.html";
		}
		break;
		case "/insert.obj": 
		
			String customerName=request.getParameter("custname");
			String phoneNo=request.getParameter("custphone");
			String password=request.getParameter("pwd");
			String repassword=request.getParameter("repwd");
			
			
			bean.setCustomerName(customerName);
			bean.setPhoneNo(phoneNo);
			bean.setPassword(password);
			bean.setRepassword(repassword);
			
			
			int res = 0;
			res = service.addDetails(bean);
			System.out.println(res);
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
		
		RequestDispatcher re=request.getRequestDispatcher(target);
		re.forward(request, response);
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
