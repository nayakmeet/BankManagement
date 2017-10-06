package com.cg.service.customer;

import javax.naming.NamingException;

import com.cg.beancontroller.CustomerBean;
import com.cg.dao.customer.CustomerDaoImpl;
import com.cg.dao.customer.ICustomerDao;


public class CustomerImpl implements ICustomer
{
	ICustomerDao dao=new CustomerDaoImpl();
	
	@Override
	public int addDetails(CustomerBean bean) throws NamingException {
	
		return dao.addDetails(bean);
	}

}