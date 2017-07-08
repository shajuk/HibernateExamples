package com.hotel.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SALESBOYS")
public class SalesBoys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SALESBOYID")
	private int salesBoyId;
	
	@Column(name="SALESBOYNAME")
	private String salesBoyName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CONTACTNO")
	private String contactNo;
	
	@Column(name="EMAILID")
	private String emailId;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="SALESBOYID")
	private Set<PizzaOrder> pizzaOrders;

	public int getSalesBoyId() {
		return salesBoyId;
	}

	public void setSalesBoyId(int salesBoyId) {
		this.salesBoyId = salesBoyId;
	}

	public String getSalesBoyName() {
		return salesBoyName;
	}

	public void setSalesBoyName(String salesBoyName) {
		this.salesBoyName = salesBoyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<PizzaOrder> getPizzaOrders() {
		return pizzaOrders;
	}

	public void setPizzaOrders(Set<PizzaOrder> pizzaOrders) {
		this.pizzaOrders = pizzaOrders;
	}
	
	
}
