package com.cg.dao.customer;

import javax.naming.NamingException;

import com.cg.beancontroller.CustomerBean;

public interface ICustomerDao {

	public int addDetails(CustomerBean bean) throws NamingException;

}
