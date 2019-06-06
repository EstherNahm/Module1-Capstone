package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Inventory {
	//Inventory of Slot ID's and associated snacks.
	private TreeMap<String, ArrayList<Snack>> slots = new TreeMap<String, ArrayList<Snack>>();
	
	public Inventory() {
		//Got the file with the inventory.
		File input = new File("vendingmachine.csv");
		//catch(NullPointerException error) {
			// handle this later
		//}
		
		//Created a place to store the data.
		String line;
		
		try {
		Scanner fileScanner = new Scanner(input);
			while (fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				String words[] = line.split("\\|");
				Snack newSnack = new Snack(words[1], Double.parseDouble(words[2]), words[3]);
				ArrayList<Snack> newSnacks = new ArrayList<Snack>();
				for(int i = 0; i < 5; i++) {
					newSnacks.add(newSnack);
				}
				slots.put(words[0], newSnacks);
			}
		}catch(FileNotFoundException e) {
			
		}

	}
	public void printContents() {
		Set <String>inventoryKeys = slots.keySet();
		for(String slotID : inventoryKeys) {
			System.out.println(slotID + ": " + slots.get(slotID).get(1) + " " + slots.get(slotID).get(2) + " " + slots.get(slotID).get(3));
		}
	}
}