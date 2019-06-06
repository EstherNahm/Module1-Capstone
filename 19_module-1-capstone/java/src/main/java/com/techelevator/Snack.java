package com.techelevator;

public class Snack {
	private String type;
	private String name;
	private double price;
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
}
