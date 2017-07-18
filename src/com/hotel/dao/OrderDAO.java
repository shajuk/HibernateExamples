package com.hotel.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.Customer;
import com.hotel.pojo.Pizza;
import com.hotel.pojo.PizzaOrder;
import com.hotel.pojo.PizzaOrderDetail;
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
	
	public void createOrderDetail(int orderId, int pizzaId, int quantity, int price){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			PizzaOrder o=(PizzaOrder)session.load(PizzaOrder.class, orderId);
			Pizza p=(Pizza)session.load(Pizza.class, pizzaId);
			PizzaOrderDetail pod=new PizzaOrderDetail();
			pod.setPizza(p);
			pod.setPizzaOrder(o);
			pod.setPrice(price);
			pod.setQuantity(quantity);
			session.save(pod);
			int totalAmnt=o.getTotalAmount();
			o.setTotalAmount(totalAmnt + (pod.getPrice() * pod.getQuantity()));
			session.saveOrUpdate(o);
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
