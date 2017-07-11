package com.hotel.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.Customer;
import com.hotel.pojo.SalesBoys;
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
			System.out.println("SalesBoy ID\tSalesBy Name\tTotal Delivery Made");
			while(it.hasNext()){
				System.out.println("-------------------------------------------------------------------------");
				Object[] row=(Object[]) it.next();
				SalesBoys s=(SalesBoys)session.load(SalesBoys.class, new Integer(row[0].toString()));
				System.out.println(s.getSalesBoyId()+"\t\t"+s.getSalesBoyName()+"\t\t"+row[1]);
			}
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<Customer> findCustomerWhoPlacedLargestNoOfOrders(){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
