package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineClass {
	Scanner fileScanner = new Scanner(System.in);
	private double balance = 0.00;
	Inventory inventory = new Inventory();
	
	public VendingMachineClass() {
		
	}
	public void printInventory() {
		inventory.printContents();
	}
		
	public void insertCash() {
		System.out.println("Please insert $1.00s, $2.00s, $5.00s or $10.00s.");
		double cashInserted = fileScanner.nextDouble();
		fileScanner.nextLine(); 
		balance += cashInserted;
		System.out.println("Your balance is: " + balance);
	}
		
	public void selectProduct() {
		while (true) {
			System.out.println("Please enter the slot ID(s) of the product(s) you'd like today!");
			String selectedProduct = fileScanner.nextLine();
			Inventory map = new Inventory();
			Inventory counts = new Inventory();
			if (map.getSlots().containsKey(selectedProduct)) {
				if(map.getSlots().isEmpty()) {
					
				}
			}
		}
	}
}