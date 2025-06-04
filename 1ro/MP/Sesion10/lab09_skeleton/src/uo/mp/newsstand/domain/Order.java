package uo.mp.newsstand.domain;

import uo.mp.util.check.ArgumentChecks;

public class Order {
	private String name;
	private int quantity;
	
	public Order(String name, int quantity){
		setName(name);
		setQuantity(quantity);

	}

	private void setQuantity(int quantity) {
		ArgumentChecks.isTrue( quantity > 0, "Trying to create a new Order: Illegal quantity under zero" );		
		this.quantity = quantity;		
	}

	private void setName(String name) {
		ArgumentChecks.isNotNull( name, "Trying to create a new Order: Illegal null argument" );
		ArgumentChecks.isNotBlank( name, "Trying to create a new Order: Illegal blank argument" );	
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString(){
		return "Order: " + getName() + "\t" + getQuantity();
	}
	
	public String serialize(){
		return  getName() + "\t" + getQuantity();
	}
	
}
