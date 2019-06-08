package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.text.SimpleDateFormat;  
import java.text.DateFormat;
import java.util.Date;
public class VendingMachineClass {
	private static Scanner fileScanner = new Scanner(System.in);
	private static double balance;
	private static double cashInserted;
	private double priceOfItem;
	private static String selectedProduct;
	private static Inventory inventory = new Inventory();
	private static ArrayList<String> typesOfItems = new ArrayList<>();
	private static File newFile;
	private static PrintWriter writer;
	private static double totalBalance = 0.00;

	//stores the transactions in name of product and number sold format
	private static TreeMap<String, Integer> sales = new TreeMap<>();

	/**
	 * @return the sales
	 */
	public static TreeMap<String, Integer> getSales() {
		return sales;
	}

	public VendingMachineClass() {
		try {
			newFile = new File("Log.txt");
			newFile.createNewFile();
			writer = new PrintWriter(newFile);
		}catch(IOException e) {
		
		}
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
	/*
	 * @param getBalance the balance to get
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
	public static void insertMoney() throws FileNotFoundException {
		System.out.println("Only insert $1.00s, $2.00s, $5.00s or $10.00s.");
		
		//Scan for inserted cash
		cashInserted = fileScanner.nextDouble();
		fileScanner.nextLine();
		
		//update the current balance 
		balance += cashInserted;
		System.out.printf("Current balance: %.2f", balance, "0");
		
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
    	String dateString = dateFormat.format(new Date()).toString();
    	Log thisAudit = new Log(dateString, "FEED MONEY:", cashInserted, balance);
		writer.println(thisAudit.toString());
	}	
	public static void selectProduct() {
		
		//retrieve the price from the Map using the key(slot ID)
		System.out.println("Enter a slot ID (A1-A4; B1-B4; C1-C4; D1-D4) to select desired product.");
		
		//scan user input for the slot number
		selectedProduct = fileScanner.nextLine();
		
		//retrieve correlating values with above key from map 
		//loop through map to look for matching key
	    Set <String> keys = inventory.getSlots().keySet();
	    if(!keys.contains(selectedProduct)) {
	   		System.out.println("Sorry, that's an invalid key.");
	   		return;
	   	}
	    
	    //assign stock to the size of the array that is the value of the map 
	    int stock = inventory.getSlots().get(selectedProduct).size();
	    if(stock == 0) {
	    	System.out.println("Sorry, that item has sold out.");
	    	return;
	    }
	    
	    //access the values that are in the map 
	    String itemPurchased = inventory.getSlots().get(selectedProduct).get(0).getName();
	    double priceOfItem = inventory.getSlots().get(selectedProduct).get(0).getPrice();
	    String typeOfItem = inventory.getSlots().get(selectedProduct).get(0).getType();
	    
	    
	   //allow purchasing for items 
	    if (balance >= priceOfItem) {
	    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
	    	String dateString = dateFormat.format(new Date()).toString();
	    	Log thisAudit = new Log(dateString, itemPurchased + " " + selectedProduct, balance, balance - priceOfItem);
	    	writer.println(thisAudit.toString());
	    	
	    	//confirm purchase and remaining balance to user 
	    	System.out.println("Yum! Enjoy your " + itemPurchased + "!");
	    	balance = (balance - priceOfItem);
	    	System.out.printf("Your remaining balance is $%.2f", balance);
	    	
	    	//update total balance for sales report 
	    	totalBalance += priceOfItem;
	    	
	    	//adds data to sales report
			sales.put(inventory.getSlots().get(selectedProduct).get(0).getName(), (int)5 - inventory.getSlots().get(selectedProduct).size() + 1);
	   		
			
			inventory.getSlots().get(selectedProduct).remove(0);
	   		stock--;
	   		System.out.println();
	   		typesOfItems.add(typeOfItem);
	   		
	   		
	   	} else { 
	   		if (balance < priceOfItem) {
	    		System.out.println("Please feed more money to make this purchase.");
	    	} 
	   	}	
	  
	}
	
	//part 3 of the purchase menu - "finish transaction"
	public static void exitOut() {
		
		//if item is sold out 
		boolean priceOfItemEmpty = inventory.getSlots().get(selectedProduct).size() <= 0;
		if(priceOfItemEmpty) {
			return;
		}
		
		//double priceOfItem1 = inventory.getSlots().get(selectedProduct).get(0).getPrice();
		System.out.println("Thank you for your purchase!");
		System.out.printf("Your remaining balance is $%.2f", balance);
		System.out.println();
		//convert dollars to cents
		double change = balance * 100; 
		
		//retrieve proper change in coins
		double quarters = change / 25;     
		change = change % 25;    

		double dimes = change / 10;
		change = change % 10;  

		double nickels = change / 5;      
		change = change % 5;   
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
	    String dateString = dateFormat.format(new Date()).toString();
	    Log thisAudit = new Log(dateString, "GIVE CHANGE: ", balance, 0.00);
	    writer.println(thisAudit.toString());
	    balance = 0.00;
		
		//print out the change in cents 
		System.out.println("Your change: ");
		System.out.println("Quarters: " + (int)quarters);
		System.out.println("Dimes: " + (int)dimes);
		System.out.println("Nickels: " + (int)nickels);
		
		
		//loop through the listArray to match the types of items with sentences 
		for(int i = 0; i < typesOfItems.size(); i++) {
			if(typesOfItems.get(i).equals("Chip")) {
				System.out.println("Crunch Crunch, Yum!");
			}                    
			if(typesOfItems.get(i).equals("Candy")) {
				System.out.println("Munch Munch, Yum!");          
			}
			if(typesOfItems.get(i).equals("Drink")) {
				System.out.println("Glug Glug, Yum!");
			}
			if(typesOfItems.get(i).equals("Gum")) {
				System.out.println("Chew Chew, Yum!");
			}
		}
		System.out.println("It was a pleasure to serve you today.");
		//must have this to close out the writer 
		writer.close();
	} 
	public static void printSales() {
		System.out.println();
		System.out.println("**SALES REPORT**");
		Set <String>salesKeys = sales.keySet();
		for(String key : salesKeys) {
			System.out.println(key + "|" + sales.get(key));
		}
		System.out.println();
		System.out.printf("**TOTAL SALES** $%.2f", totalBalance);
	}
}	