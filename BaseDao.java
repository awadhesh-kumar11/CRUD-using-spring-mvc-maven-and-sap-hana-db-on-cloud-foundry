package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao 
{
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession()
	{
		try
		{
			return sessionFactory.getCurrentSession();
		}
		catch (Exception e) 
		{
			return sessionFactory.openSession();
		}
	}
}
