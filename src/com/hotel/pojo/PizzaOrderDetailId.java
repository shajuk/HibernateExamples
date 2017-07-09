package com.hotel.pojo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PizzaOrderDetailId implements Serializable{
	
	@ManyToOne
	private Pizza pizza;
	
	@ManyToOne
	private PizzaOrder pizzaOrder;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public PizzaOrder getPizzaOrder() {
		return pizzaOrder;
	}

	public void setPizzaOrder(PizzaOrder pizzaOrder) {
		this.pizzaOrder = pizzaOrder;
	}
	
	
	
}
