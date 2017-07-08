package com.hotel.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZAORDER")
public class PizzaOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDERID")
	private int orderId;
	
	@Column(name="ORDERDATE")
	private Date orderDate;
	
	@Column(name="TOTALAMOUNT")
	private int totalAmount;
	
	@Column(name="CUSTOMER_NO")
	private int customerNo;
	
	@Column(name="SALESBOYID")
	private int salesBoyId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_NO")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SALESBOYID")
	private SalesBoys salesBoys;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pizzaOrderDetailId.pizzaOrder")
	private Set<PizzaOrderDetail> pizzaOrderDetails=new HashSet<PizzaOrderDetail>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getSalesBoyId() {
		return salesBoyId;
	}

	public void setSalesBoyId(int salesBoyId) {
		this.salesBoyId = salesBoyId;
	}
	
	
}
