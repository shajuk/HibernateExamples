package com.hotel.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PIZZA")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIZZAID")
	private int pizzaId;
	
	@Column(name="PIZZANAME")
	private int pizzaName;
	
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.LAZY , mappedBy="pizzaOrderDetailId.pizza" )
	private Set<PizzaOrderDetail> pizzaOrderDetails=new HashSet<PizzaOrderDetail>();

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public int getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(int pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Set<PizzaOrderDetail> getPizzaOrderDetails() {
		return pizzaOrderDetails;
	}

	public void setPizzaOrderDetails(Set<PizzaOrderDetail> pizzaOrderDetails) {
		this.pizzaOrderDetails = pizzaOrderDetails;
	}
	
	
}
