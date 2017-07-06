package com.hotel.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.pojo.Address;
import com.hotel.pojo.Customer;
import com.hotel.pojo.MembershipCard;
import com.hotel.util.HibernateUtil;

public class CustomerDAO {
	
	public void storeCustomerDetails(Customer customer,Address address){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			customer.setAddress(address);
			session.save(customer);
			session.flush();
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void enrollForMembershipCard(int customerId, MembershipCard card){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Customer c=(Customer)session.load(Customer.class, customerId);
			card.setCustomer(c);
			card.setPointsEarned(100);
			session.save(card);
			session.flush();
			t.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
