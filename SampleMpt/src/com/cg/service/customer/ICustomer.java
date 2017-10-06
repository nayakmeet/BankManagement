package com.cg.service.customer;

import javax.naming.NamingException;

import com.cg.beancontroller.CustomerBean;

public interface ICustomer {
	
	public int addDetails(CustomerBean bean) throws NamingException;

}
