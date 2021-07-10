package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.RegVO;

@Repository
public class RegDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void insert(RegVO v) {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(v);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List search() {
		// TODO Auto-generated method stub
		List is=new ArrayList<>();
		try
		{
			Session session=sessionFactory.openSession();
			//Transaction transaction = session.beginTransaction();`
			Query q = session.createQuery("from RegVO");
			is=q.list();
			//transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return is;
	}

	public void delete(RegVO v) {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(v);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List edit(RegVO v) {
		// TODO Auto-generated method stub
		List is=new ArrayList<>();
		try
		{
			Session session=sessionFactory.openSession();
			//Transaction transaction = session.beginTransaction();`
			Query q = session.createQuery("from RegVO where id="+v.getId());
			is=q.list();
			//transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return is;
	}

	public void update(RegVO v) {
		// TODO Auto-generated method stub
		try
		{
			Session session=sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(v);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
