package com.hotel.dao;


import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.util.HibernateUtil;

public class PizzaStoreDAO {
	
	public void findTotalDeliveryMadeByEachSalesBoy(){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Query q=session.createQuery(" select pizzaOrder.salesBoys.salesBoyId, count(pizzaOrder.salesBoys.salesBoyId) "
					+ "from PizzaOrder pizzaOrder group by pizzaOrder.salesBoys.salesBoyId");
			@SuppressWarnings("unchecked")
			Iterator<Object[]> it=q.iterate();
			while(it.hasNext()){
				Object[] row=(Object[]) it.next();
				System.out.println("SalesBoy Id: "+row[0]);
				System.out.println("Total Delivery Made: "+row[1]);
			}
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
