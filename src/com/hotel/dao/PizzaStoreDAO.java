package com.hotel.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.hotel.pojo.Customer;
import com.hotel.pojo.PizzaOrder;
import com.hotel.util.HibernateUtil;

public class PizzaStoreDAO {
	
	public void findTotalDeliveryMadeByEachSalesBoy(){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Query q=session.createQuery(" select pizzaOrder.salesBoys.salesBoyId, count(pizzaOrder.salesBoys.salesBoyId) "
					+ "from PizzaOrder pizzaOrder group by pizzaOrder.salesBoys.salesBoyId order by count(pizzaOrder.salesBoys.salesBoyId) asc");
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
	
	public List<Customer> findCustomerWhoPlacedLargestNoOfOrders(){
		Session session=null;
		List<Customer> customers=new ArrayList<Customer>();
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Criteria c=session.createCriteria(PizzaOrder.class, "pizzaOrder");
			@SuppressWarnings({  "unchecked" })
			List<Object[]> rows=c.setProjection(Projections.projectionList().add(
						Projections.groupProperty("pizzaOrder.customer.customerNo")).add(
						Projections.alias(Projections.count("pizzaOrder.customer.customerNo"), "customerCount")))
						.addOrder(Order.desc("customerCount")).list();
		
			for(Object[] object:rows){
				//System.out.println(object[0]+" "+object[1]);
				Customer customer=(Customer)session.get(Customer.class,new Integer(object[0].toString()));
				customers.add(customer);
			}
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return customers;
	}
	
	
}
