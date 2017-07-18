package com.hotel.pojo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PIZZAORDERDETAIL")
@AssociationOverrides({
	@AssociationOverride(name="pizzaOrderDetailId.pizza" , joinColumns=@JoinColumn(name="PIZZAID")),
	@AssociationOverride(name="pizzaOrderDetailId.pizzaOrder" , joinColumns=@JoinColumn(name="ORDERID"))
})
public class PizzaOrderDetail {
	
	@EmbeddedId
	private PizzaOrderDetailId pizzaOrderDetailId=new PizzaOrderDetailId();
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="PRICE")
	private int price;
	
	public Pizza getPizza() {
		return getPizzaOrderDetailId().getPizza();
	}

	public void setPizza(Pizza pizza) {
		getPizzaOrderDetailId().setPizza(pizza);
	}

	public PizzaOrder getPizzaOrder() {
		return getPizzaOrderDetailId().getPizzaOrder();
	}

	public void setPizzaOrder(PizzaOrder pizzaOrder) {
		getPizzaOrderDetailId().setPizzaOrder(pizzaOrder);
	}

	public PizzaOrderDetailId getPizzaOrderDetailId() {
		return pizzaOrderDetailId;
	}

	public void setPizzaOrderDetailId(PizzaOrderDetailId pizzaOrderDetailId) {
		this.pizzaOrderDetailId = pizzaOrderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
