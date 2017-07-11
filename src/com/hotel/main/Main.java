package com.hotel.main;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import com.hotel.dao.CustomerDAO;
import com.hotel.dao.OrderDAO;
import com.hotel.dao.PizzaDAO;
import com.hotel.dao.PizzaStoreDAO;
import com.hotel.dao.SalesBoyDAO;
import com.hotel.pojo.Address;
import com.hotel.pojo.Customer;
import com.hotel.pojo.MembershipCard;
import com.hotel.pojo.Pizza;
import com.hotel.pojo.PizzaOrder;

public class Main {
	public static void main(String[] args) {
		
		//Scenario #1
//		CustomerDAO customerDAO=new CustomerDAO();
//		Customer customer=new Customer();
//		Address address=new Address();
//		customer.setCustomerName("Benny");
//		address.setCity("Kochi");
//		address.setContactNo(62625);
//		address.setDoorNo("503");
//		address.setEmailId("benny@gmail.com");
//		address.setPincode(87458);
//		address.setState("Kerala");
//		address.setStreet("sagarika street");
//		customer.setAddress(address);
//		customerDAO.storeCustomerDetails(customer, address);
//		MembershipCard card=new MembershipCard();
//		customerDAO.enrollForMembershipCard(customer.getCustomerNo(), card);
//		
//		Customer customer2=new Customer();
//		Address address2=new Address();
//		customer2.setCustomerName("Linto");
//		address2.setCity("Kochi");
//		address2.setContactNo(78569);
//		address2.setDoorNo("875");
//		address2.setEmailId("linto@gmail.com");
//		address2.setPincode(87458);
//		address2.setState("Kerala");
//		address2.setStreet("jango street");
//		customer2.setAddress(address2);
//		customerDAO.storeCustomerDetails(customer2, address2);
//		MembershipCard card2=new MembershipCard();
//		customerDAO.enrollForMembershipCard(customer2.getCustomerNo(), card2);
//		
//		Customer customer3=new Customer();
//		Address address3=new Address();
//		customer3.setCustomerName("Rinku");
//		address3.setCity("Delhi");
//		address3.setContactNo(24567);
//		address3.setDoorNo("745");
//		address3.setEmailId("rinku@gmail.com");
//		address3.setPincode(623541);
//		address3.setState("Delhi");
//		address3.setStreet("L.B street");
//		customer3.setAddress(address3);
//		customerDAO.storeCustomerDetails(customer3, address3);
//		MembershipCard card3=new MembershipCard();
//		customerDAO.enrollForMembershipCard(customer3.getCustomerNo(), card3);
		//Scenario #1 ends
		
		//Scenario #2 
//		PizzaDAO pizzaDAO=new PizzaDAO();
//		Set<Pizza> pizzas=new HashSet<Pizza>();
//		Pizza p1=new Pizza();
//		p1.setPizzaName("Onion Pizza");
//		pizzas.add(p1);
//		Pizza p2=new Pizza();
//		p2.setPizzaName("Chicken Pizza");
//		pizzas.add(p2);
//		Pizza p3=new Pizza();
//		p3.setPizzaName("BBQ Pizza");
//		pizzas.add(p3);
//		Pizza p4=new Pizza();
//		p4.setPizzaName("Corn Pizza");
//		pizzas.add(p4);
//		Pizza p5=new Pizza();
//		p5.setPizzaName("Cheesy Pizza");
//		pizzas.add(p5);
//		pizzaDAO.createPizzas(pizzas);
		
//		OrderDAO orderDAO=new OrderDAO();
//		Set<PizzaOrder> orderObjs=new HashSet<PizzaOrder>();
//		PizzaOrder o1=new PizzaOrder();
//		o1.setOrderDate(new Date());
//		orderObjs.add(o1);
//		PizzaOrder o2=new PizzaOrder();
//		o2.setOrderDate(new Date());
//		orderObjs.add(o2);
//		PizzaOrder o3=new PizzaOrder();
//		o3.setOrderDate(new Date());
//		orderObjs.add(o3);
//		orderDAO.createOrder(18, orderObjs);
//		
//		Set<PizzaOrder> orderObjs1=new HashSet<PizzaOrder>();
//		PizzaOrder oc1=new PizzaOrder();
//		oc1.setOrderDate(new Date());
//		orderObjs1.add(oc1);
//		orderDAO.createOrder(17, orderObjs1);
//
//		Set<PizzaOrder> orderObjs2=new HashSet<PizzaOrder>();
//		PizzaOrder oc2=new PizzaOrder();
//		oc2.setOrderDate(new Date());
//		orderObjs2.add(oc2);
//		PizzaOrder oc3=new PizzaOrder();
//		oc3.setOrderDate(new Date());
//		orderObjs2.add(oc3);
//		orderDAO.createOrder(19, orderObjs2);
		
//		orderDAO.createOrderDetail(1, 2, 1, 80);
//		orderDAO.createOrderDetail(2, 5, 1, 50);
//		orderDAO.createOrderDetail(3, 1, 2, 150);
//		
//		orderDAO.createOrderDetail(4, 5, 1, 80);
//		
//		orderDAO.createOrderDetail(5, 3, 1, 100);
//		orderDAO.createOrderDetail(6, 4, 2, 120);
//		
		//Scenario #2 ends
		
		//Scenario #3
//		SalesBoyDAO sbd=new SalesBoyDAO();
//		sbd.assignOrderToSalesBoy(1, 100);
//		sbd.assignOrderToSalesBoy(2, 100);
//		sbd.assignOrderToSalesBoy(3, 100);
//		
//		sbd.assignOrderToSalesBoy(4, 101);
//		
//		sbd.assignOrderToSalesBoy(5, 102);
//		sbd.assignOrderToSalesBoy(6, 102);
		//Scenario #3 ends
		
		//Scenario #4
		PizzaStoreDAO pizzaStoreDAO=new PizzaStoreDAO();
		pizzaStoreDAO.findTotalDeliveryMadeByEachSalesBoy();
		List<Customer> customers=pizzaStoreDAO.findCustomerWhoPlacedLargestNoOfOrders();
		for(Customer c:customers){
			System.out.println(c.getCustomerNo()+"\t"+c.getCustomerName());
		}
		//Scenario #4 ends
		
		
	}
}
