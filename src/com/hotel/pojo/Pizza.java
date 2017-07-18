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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="PIZZA")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY , region="pizzaStoreCache")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIZZAID")
	private int pizzaId;
	
	@Column(name="PIZZANAME")
	private String pizzaName;
	
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.LAZY , mappedBy="pizzaOrderDetailId.pizza" )
	private Set<PizzaOrderDetail> pizzaOrderDetails=new HashSet<PizzaOrderDetail>();

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public Set<PizzaOrderDetail> getPizzaOrderDetails() {
		return pizzaOrderDetails;
	}

	public void setPizzaOrderDetails(Set<PizzaOrderDetail> pizzaOrderDetails) {
		this.pizzaOrderDetails = pizzaOrderDetails;
	}
	
	
}
