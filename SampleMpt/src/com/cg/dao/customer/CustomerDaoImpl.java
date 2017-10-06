package com.cg.dao.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.cg.beancontroller.CustomerBean;
import com.cg.dbutil.DbUtil;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public int addDetails(CustomerBean bean) throws NamingException {
		Connection conn=null;
		int rows=0;
		try{
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into billdetails values(?,?,?,?)");
			ps.setInt(1,bean.getConsumerNo());
			ps.setString(2,bean.getCustomerName());
			ps.setString(3,bean.getEmailId());
			ps.setString(4, bean.getPhoneNo());
			
			rows=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
		return rows;
	
	}
	}

