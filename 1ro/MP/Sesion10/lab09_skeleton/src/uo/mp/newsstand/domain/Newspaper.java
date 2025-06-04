package uo.mp.newsstand.domain;

import uo.mp.newsstand.exception.NewsstandException;

public class Newspaper extends Publication {

	private static final int MIN_COPIES = 0;

	public Newspaper(String name, int stock, int sales) {
		super(name, sales, stock);
	}


	@Override
	public Order generateOrders() throws NewsstandException {
		if(getStock() < MIN_COPIES) {
			return new Order(getName(), getSales() + (getStock() * 2));
		}else {
			throw new NewsstandException("No es necesario pedido para " + getName());
		}
	
	}

	@Override
	public String serialize() {
		return "newspaper" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}
}
