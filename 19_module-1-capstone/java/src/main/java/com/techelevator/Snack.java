package com.techelevator;

public class Snack {
	
	private String type;
	private String name;
	private double price;
	private int stock;
	public Snack(String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "|" + price + "|" + type;
	}
}
	


