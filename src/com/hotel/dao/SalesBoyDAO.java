package com.hotel.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.PizzaOrder;
import com.hotel.pojo.SalesBoys;
import com.hotel.util.HibernateUtil;

public class SalesBoyDAO {
	
	public void assignOrderToSalesBoy(int orderId, int salesBoyId){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			PizzaOrder o=(PizzaOrder)session.load(PizzaOrder.class, orderId);
			SalesBoys s=(SalesBoys)session.load(SalesBoys.class, salesBoyId);
			o.setSalesBoys(s);
			session.saveOrUpdate(o);
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
}
