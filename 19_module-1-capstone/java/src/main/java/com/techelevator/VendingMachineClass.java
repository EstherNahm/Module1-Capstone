package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineClass {
	public static void main(String[] args) throws FileNotFoundException {
		VendingMachineClass ourVendingMachine = new VendingMachineClass();
		File input = new File("vendingmachine.csv");
		String line;
		try (Scanner fileScanner = new Scanner(input)) {
			while (fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				System.out.println(line);
			}
		} 
	}
	public VendingMachineClass() {
		
	}
}