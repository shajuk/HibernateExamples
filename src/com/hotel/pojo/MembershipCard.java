package com.hotel.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="MEMBERSHIPCARD")
public class MembershipCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CARDNO")
	private int cardNo;
	
	@Column(name="POINTSEARNED")
	private int pointsEarned;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_NO")
	private Customer customer;

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public int getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
