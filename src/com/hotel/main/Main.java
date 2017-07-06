package com.hotel.main;

import com.hotel.dao.CustomerDAO;
import com.hotel.pojo.Address;
import com.hotel.pojo.Customer;
import com.hotel.pojo.MembershipCard;

public class Main {
	public static void main(String[] args) {
		
		//Scenario #1
		CustomerDAO customerDAO=new CustomerDAO();
		Customer customer=new Customer();
		Address address=new Address();
		customer.setCustomerName("John");
		address.setCity("Kochi");
		address.setContactNo(12345);
		address.setDoorNo("501");
		address.setEmailId("john@gmail.com");
		address.setPincode(87458);
		address.setState("Kerala");
		address.setStreet("jango street");
		customer.setAddress(address);
		customerDAO.storeCustomerDetails(customer, address);
		MembershipCard card=new MembershipCard();
		customerDAO.enrollForMembershipCard(customer.getCustomerNo(), card);
		//Scenario #1 ends
		
		
	}
}
