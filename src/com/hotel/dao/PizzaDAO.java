package com.hotel.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.Pizza;
import com.hotel.util.HibernateUtil;

public class PizzaDAO {
	
	public void createPizzas(Set<Pizza> pizzas){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			for(Pizza p:pizzas){
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
