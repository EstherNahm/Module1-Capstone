package com.techelevator;

public class Dispenser extends Transaction {
	private double changeToGiveBack;
	private int numOfNickels;
	private int numOfDimes;
	private int numOfQuarters;

	public void Dispenser() {
		if (changeToGiveBack % 5 == 0) {
			if (changeToGiveBack % 10 == 0) {
				if (changeToGiveBack % 25 == 0) {
					
				}
			}
		}
		
		/*balance = 0.00;
		
		if (type.equalsIgnoreCase("chip")) {
			System.out.println("Crunch Crunch, Yum!");
		}
		if (type.equalsIgnoreCase("candy")) {
			System.out.println("Munch Munch, Yum!");
		}
		if (type.equalsIgnoreCase("beverage")) {
			System.out.println("Glug Glug, Yum!");
		}
		if (type.equalsIgnoreCase("gum")) {
			System.out.println("Chew Chew, Yum!");
		}
	 */
	}
}
