package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineClass {
	private static Scanner fileScanner = new Scanner(System.in);
	private static double balance;
	private double priceOfItem;
	private static Inventory inventory = new Inventory();
	

	public VendingMachineClass() {

	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @param priceOfItem the priceOfItem to set
	 */
	public void setPriceOfItem(double priceOfItem) {
		this.priceOfItem = priceOfItem;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the priceOfItem
	 */
	
	
	public double getPriceOfItem() {
		return priceOfItem;
	}

	public void printInventory() {
		inventory.printContents();
	}
	
	public static void insertMoney() {
		System.out.println("Only insert $1.00s, $2.00s, $5.00s or $10.00s, please.");
		
		//Scan for inserted cash
		double cashInserted = fileScanner.nextDouble();
		fileScanner.nextLine();
		
		//update the current balance 
		balance += cashInserted;
		System.out.println(balance);
		}
		
	
		
	public static void selectProduct() {
		//retrieve the price from the Map using the key(slot ID)
		System.out.println("Enter the slot ID to select desired product.");
		
		//scan user input for the slot number
		String selectedProduct = fileScanner.nextLine();
		
		//retrieve correlating values with above key from map 
		String itemPurchased = inventory.getSlots().get(selectedProduct).get(1).getName();
		double priceOfItem = inventory.getSlots().get(selectedProduct).get(1).getPrice();
		int stock = inventory.getSlots().get(selectedProduct).get(1).getStock();
		
		//loop through map to look for matching key
		//for when product code doesn't exist 
	//	Set <String> keys = inventory.getSlots().get(key);
		
		//currently only prints when no balance, NOT MATCHING OF KEYS
		//********WHY????
		
	//	for(String key : slots) {
	//		if (!selectedProduct.equals(key)) {
//				System.out.println("Sorry, that is an invalid key.");
//				break;
//		}
//		}
//		//if product is sold out
//			if (stock == 0) { 
//				System.out.println("Sorry, that item is out of stock.");
//			} 
		
		

		//if all is good, dispense product & update balance 
		if (balance >= priceOfItem && stock >=5) { 
			System.out.println("Yum. Enjoy your " + itemPurchased);
			balance = (balance - priceOfItem);
			System.out.printf("Your remaining balance is %.2f", balance);
			System.out.println();
			stock--;
		} if (balance <= priceOfItem) {
			System.out.println("Please feed more money before making this purchase.");
		}
}
	
	//finish out the transaction and make change 
	public static void exitOut() {
		//***need to figure out how to access the key from snack class 
		//Snack snackType = inventory.getSlots().get(1).get(3);
		//System.out.println(snackType);
		
		System.out.printf("Thank you for your purchase! Your remaining balance is %.2f", balance);
		System.out.println();
		double change = balance * 100; //converts the remaining balance in dollars to cents
		
		double quarters = change / 25;     
		change = change % 25;    

		double dimes = change / 10;
		change = change % 10;  

		double nickels = change / 5;      
		change = change % 5;   

		double pennies = change;
		balance = 0;
		
		System.out.println("Here is your change: ");
		System.out.println("Quarters: " + (int)quarters);
		System.out.println("Dimes: " + (int)dimes);
		System.out.println("Nickels: " + (int)nickels);
		System.out.println("Pennies: " + (int)pennies); 
		System.out.println("Balance: 0.00");
		System.out.println("It was a pleasure to serve you today.");
		System.out.println("Please hit refresh on your way out!");
	}
}	