package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class VendingMachineClass {
	
	Inventory newInventory = new Inventory();
	
	public VendingMachineClass() {
		
	}
	public void printInventory() {
		newInventory.printContents();
	}
}