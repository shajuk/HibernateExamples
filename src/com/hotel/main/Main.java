package com.hotel.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hotel.dao.CustomerDAO;
import com.hotel.dao.OrderDAO;
import com.hotel.dao.PizzaDAO;
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
		
		OrderDAO orderDAO=new OrderDAO();
//		Set<PizzaOrder> orderObjs=new HashSet<PizzaOrder>();
//		PizzaOrder o1=new PizzaOrder();
//		o1.setOrderDate(new Date());
//		orderObjs.add(o1);
//		
//		PizzaOrder o2=new PizzaOrder();
//		o2.setOrderDate(new Date());
//		orderObjs.add(o2);
//		
//		orderDAO.createOrder(2, orderObjs);
//		System.out.println(o1.getOrderId());
//		System.out.println(o2.getOrderId());
		
		orderDAO.createOrderDetail(18, 2, 1, 60);
		//Scenario #2 ends
		
		
	}
}
