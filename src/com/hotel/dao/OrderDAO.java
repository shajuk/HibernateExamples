package com.hotel.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.Customer;
import com.hotel.pojo.PizzaOrder;
import com.hotel.util.HibernateUtil;

public class OrderDAO {
	
	public void createOrder(int customerID, Set<PizzaOrder> orderObjs){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Customer c=(Customer)session.load(Customer.class, customerID);
			
			for(PizzaOrder p:orderObjs){
				p.setCustomer(c);
				session.save(p);
				session.flush();
				session.clear();
			}
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
