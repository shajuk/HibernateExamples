package com.hotel.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.ehcache.Statistics;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.hotel.pojo.Customer;
import com.hotel.pojo.Pizza;
import com.hotel.pojo.PizzaOrder;
import com.hotel.pojo.SalesBoys;
import com.hotel.util.HibernateUtil;

public class PizzaStoreDAO {
	
	public void findTotalDeliveryMadeByEachSalesBoy(){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Query q=session.createQuery(" select pizzaOrder.salesBoys.salesBoyId, count(pizzaOrder.salesBoys.salesBoyId) "
					+ "from PizzaOrder pizzaOrder group by pizzaOrder.salesBoys.salesBoyId "
					+ "order by count(pizzaOrder.salesBoys.salesBoyId) desc");
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
		}/*finally{
			session.close();
		}*/
	}
	
	public List<Customer> findCustomerWhoPlacedLargestNoOfOrders(){
		Session session=null;
		List<Customer> customers=new ArrayList<Customer>();
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction t=session.beginTransaction();
			Criteria c=session.createCriteria(PizzaOrder.class, "pizzaOrder");
			@SuppressWarnings("unchecked")
			List<Object[]> rows=c.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("pizzaOrder.customer.customerNo"))
					.add(Projections.alias(Projections.count("pizzaOrder.customer.customerNo"), "customerCount")))
					.addOrder(Order.desc("customerCount")).list();
			for(Object[] object:rows){
				Customer customer=(Customer)session.get(Customer.class, object[0].toString());
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
	
	public List<Pizza> getAvailablePizzas(){
		Session session=null;
		try{
			session=HibernateUtil.getSessionFactory().openSession();
			org.hibernate.stat.Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
			
			stats.setStatisticsEnabled(true);
			System.out.println("Stats enabled="+stats.isStatisticsEnabled());
			Transaction t=session.beginTransaction();
			Query q=session.createQuery("from Pizza");
			q.setCacheable(true);
			q.setCacheRegion("pizzaStoreCache");
			@SuppressWarnings("unchecked")
			List<Pizza> pizzas=q.list();
			for(Pizza p:pizzas){
				System.out.println(p.getPizzaName());
			}
			return pizzas;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
