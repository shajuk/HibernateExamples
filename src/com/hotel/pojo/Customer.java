package com.hotel.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMERNO")
	private int customerNo;
	
	@Column(name="CUSTOMERNAME")
	private String customerName;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
	private MembershipCard card;

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MembershipCard getCard() {
		return card;
	}

	public void setCard(MembershipCard card) {
		this.card = card;
	}
	
}
